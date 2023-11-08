package com.study.prictice.demos.utils;

/**
 * @Author ouyang    @Date 2023/4/2
 * @Description
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Description:(cmd方式调用ffmpeg使用)
 * @author: HeShengjin
 * @date:   2021年6月22日 下午5:32:31
 * @Copyright:
 */
public class FfmpegCmdTest {
    //执行成功0,失败1
    private static int CODE_SUCCESS = 0;
    private static int CODE_FAIL = 1;
    //将荣耀视频测试.mp4转换荣耀视频测试_转码.mov格式
    private static String cmd_mp4_2_mov = " -i D:\\Test\\inputmp4.mp4 D:\\Test\\inputmp4_转码.mov ";
    //将荣耀视频测试_转码.mov添加水印（2356899074@qq.com）荣耀视频测试_转码_水印.mov
    private static String cmd_mov_water = " -i D:\\Test\\inputmp4_转码.mov -vf \"drawtext=fontfile=Arial.ttf:text='2356899074@qq.com':y=h-line_h-20:x=(w-text_w)/2:fontsize=34:fontcolor=yellow:shadowy=2\" -b:v 3000k D:\\\\Test\\inputmp4_转码_水印.mov ";

    //多线程
    private static int core = Runtime.getRuntime().availableProcessors();
    private static ExecutorService pool = new ThreadPoolExecutor(core,//核心
            core * 2,//最大
            0L,//空闲立即退出
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),//无边界阻塞队列
            new ThreadPoolExecutor.AbortPolicy());
    /**
     * 第一步：mp4转mov
     * 第二步：mov添加水印
     * @param: @param args
     * @return: void
     * @throws
     */
    public static void main(String[] args) {

        //异步执行，获取执行结果code
        CompletableFuture<Integer> completableFutureTask = CompletableFuture.supplyAsync(() ->{
                    return cmdExecut(cmd_mp4_2_mov);
                }, pool)
                .thenApplyAsync((Integer code)->{
                    if(CODE_SUCCESS != code) {return CODE_FAIL;}
                    System.out.println("第一步：mp4转mov,成功！");
                    Integer codeTmp =  cmdExecut(cmd_mov_water);
                    if(CODE_SUCCESS != codeTmp) {return CODE_FAIL;}
                    System.out.println("第二步：mov添加水印,成功！");
                    return codeTmp;
                }, pool);

        //获取执行结果
        //code=0表示正常
        try {
            System.out.println(String.format("获取最终执行结果:%s", completableFutureTask.get() == CODE_SUCCESS ? "成功！" : "失败！"));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @Description: (执行ffmpeg自定义命令)
     * @param: @param cmdStr
     * @param: @return
     * @return: Integer
     * @throws
     */
    public static Integer cmdExecut(String cmdStr) {
        //code=0表示正常
        Integer code  = null;
        FfmpegCmd ffmpegCmd = new FfmpegCmd();
        /**
         * 错误流
         */
        InputStream errorStream = null;
        try {
            //destroyOnRuntimeShutdown表示是否立即关闭Runtime
            //如果ffmpeg命令需要长时间执行，destroyOnRuntimeShutdown = false

            //openIOStreams表示是不是需要打开输入输出流:
            //	       inputStream = processWrapper.getInputStream();
            //	       outputStream = processWrapper.getOutputStream();
            //	       errorStream = processWrapper.getErrorStream();
            ffmpegCmd.execute(false, true, cmdStr);
            errorStream = ffmpegCmd.getErrorStream();

            //打印过程
            int len = 0;
            while ((len=errorStream.read())!=-1){
                System.out.print((char)len);
            }

            //code=0表示正常
            code = ffmpegCmd.getProcessExitCode();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ffmpegCmd.close();
        }
        //返回
        return code;
    }

}

