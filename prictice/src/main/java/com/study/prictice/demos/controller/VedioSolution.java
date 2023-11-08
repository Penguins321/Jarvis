package com.study.prictice.demos.controller;

import com.study.prictice.demos.service.impl.VedioSolutionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ouyang    @Date 2023/3/31
 * @Description
 */
@RestController
@RequestMapping("/ffmpeg")
public class VedioSolution {

    @Autowired
    private VedioSolutionServiceImpl vedioSolutionService;

    @GetMapping("/useFfmpeg")
    public String useFfmpeg(){
        try {
            vedioSolutionService.useFfmpeg();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败了，但是别急");
        }
        return "成功";
    }


}
