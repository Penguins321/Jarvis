package com.study.prictice.demos.utils;

import java.io.File;

/**
 * @Author ouyang    @Date 2023/3/30
 * @Description  视频.mov格式转.MP4格式
 */
public class VideoFormatConversion {



    private void conversion(String fileName){
        File file = new File(fileName + ".Zip");

        /*
        * 思路：
        *1、文件上传的时候就要转格式-----看看怎么上传的文件               https://crmtest.hione.com:10000/fc/file/v6/upload
        *   获取文件原本存储的路径    /fc/file/v6/download/文件名
        *   对应文件调用ffmpng的Linux命令转格式，存储路径为原来保存的路径   安装ffmpeg后需要将运行路径添加到系统变量，这样才能调用
        *
        *   转格式之后删除原来文件
        *   路径返回给前端
        *
        * */

    }



}
