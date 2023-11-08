package com.study.prictice.demos.service.impl;

import com.study.prictice.demos.service.VedioSolutionService;
import com.study.prictice.demos.utils.FfmpegCmd;
import org.springframework.stereotype.Service;

/**
 * @Author ouyang    @Date 2023/3/31
 * @Description  使用视频工具类
 */
@Service
public class VedioSolutionServiceImpl implements VedioSolutionService {


    /**
     * @author ouyang
     * @date 2023/3/31
     * @description 测试调用视频格式转换工具
     * @param :
     * @return void
     */
    @Override
    public void useFfmpeg() {
        FfmpegCmd ffmpegCmd = new FfmpegCmd();

        //定义调用ffmpeg的命令
        String useFfmpegConmmend = "-i C:\\\\Users\\\\hsj\\\\AppData\\\\Local\\\\Temp\\\\jave\\\\honer.mp4 -c copy C:\\\\Users\\\\hsj\\\\AppData\\\\Local\\\\Temp\\\\jave\\\\honer_test.mov";

    }
}
