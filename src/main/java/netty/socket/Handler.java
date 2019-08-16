package netty.socket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.concurrent.GlobalEventExecutor;
import netty.websocket.Global;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static io.netty.handler.codec.http.HttpHeaderNames.*;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class Handler extends ChannelInboundHandlerAdapter {

    private static Logger logger =  Logger.getLogger(Handler.class);

    public static ChannelGroup users =
            new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //http://crysislinux.github.io/smart_websocket_client/
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object o)  {
        String json="";
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        logger.info("===================进入=======================");
        if (o instanceof FullHttpRequest) {
            logger.info("http");
            json= handleHttpRequest(ctx, (FullHttpRequest) o);
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(json.getBytes(StandardCharsets.UTF_8)));
            response.headers().set(ACCESS_CONTROL_ALLOW_ORIGIN,"*");
            response.headers().set(ACCESS_CONTROL_ALLOW_HEADERS,"Origin, X-Requested-With, Content-Type, Accept");
            response.headers().setInt(CONTENT_LENGTH, response.content().readableBytes());
            ctx.writeAndFlush(response);
            System.out.println("aaaaaaaa");
        } else if (o instanceof WebSocketFrame) {
            logger.info("websocket");
             json=handleWebSocketFrame(ctx,(TextWebSocketFrame) o);
             //judgement_action(((TextWebSocketFrame) o).text(),ctx.channel());
        }
         logger.info("返回数据"+json);
    }


    private String handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest fuHr) {
        String url = fuHr.uri().split("/")[1];
        logger.info("URL: "+url);
        System.out.println(url);
        ByteBuf byteBuf=fuHr.content();//shuju
        String data=byteBuf.toString(Charset.forName("utf-8"));
        System.out.println(data);
        Class c= null;
        try {
            c = Class.forName("controller."+url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object object= null;
        try {
            object = c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method method= null;
        try {
            method = c.getMethod("Return", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        String json= null;
        try {
            json = (String) method.invoke(object,data);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(json);

        return json;
    }

    private String  handleWebSocketFrame(ChannelHandlerContext ctx,WebSocketFrame frame){

       /* if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame
                    .retain());
        }

        // 判断是否ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(
                    new PongWebSocketFrame(frame.content().retain()));
            return;
        }*/

        // 本例程仅支持文本消息，不支持二进制消息
        if (!(frame instanceof TextWebSocketFrame)) {

            System.out.println("本例程仅支持文本消息，不支持二进制消息");
            throw new UnsupportedOperationException(String.format(
                    "%s frame types not supported", frame.getClass().getName()));
        }

        // 返回应答消息
        String request = ((TextWebSocketFrame) frame).text();

        System.out.println("服务端收到：" + request);

        TextWebSocketFrame tws = new TextWebSocketFrame(new Date().toString()
                + ctx.channel().id() + "：" + request);

        // 群发
        Global.group.writeAndFlush(tws);

        // 返回【谁发的发给谁】
        // ctx.channel().writeAndFlush(tws);
        return "hello";
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("==================channelInactive"+ctx.channel().id()+"========================");
        users.remove(ctx.channel());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        logger.info("==================userEventTriggered"+ctx.channel().id()+"========================");
        users.add(ctx.channel());
    }


}
