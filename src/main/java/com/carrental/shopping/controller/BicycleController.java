package com.carrental.shopping.controller;

import com.carrental.common.RestResult;
import com.carrental.shopping.service.BicycleService;
import com.carrental.shopping.service.vo.BicycleTypeVo;
import com.carrental.shopping.vo.BicycleDelVo;
import com.carrental.shopping.vo.BicycleEditVo;
import com.carrental.shopping.vo.BicycleVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 23:47
 * @Description:
 */

@Controller
public class BicycleController {

    @Autowired
    private BicycleService bicycleService;

    @RequestMapping("bicycleManagement")
    public String bicycleManagement(){
        return "bicycle";
    }
    @RequestMapping("bicycleEditIndex")
    public String bicycleEditIndex(){
        return "bicycleedit";
    }

    @RequestMapping("bicycleList")
    @ResponseBody
    public List<BicycleVo> bicycleList(){
        return bicycleService.bicycleList();
    }

    @RequestMapping("deleteBicycle")
    @ResponseBody
    public RestResult deleteBicycle(@RequestParam("id") Integer id){
        bicycleService.deleteBicycle(id);
        return RestResult.success();
    }

    @RequestMapping("editBicycle")
    @ResponseBody
    public RestResult editBicycle(@RequestBody BicycleEditVo editVo){
        bicycleService.editBicycle(editVo);
        return RestResult.success();
    }

    @RequestMapping("addBicycle")
    @ResponseBody
    public RestResult addBicycle(@RequestBody BicycleEditVo editVo){
        bicycleService.addBicycle(editVo);
        return RestResult.success();
    }

    @RequestMapping("bicycleType")
    @ResponseBody
    public List<BicycleTypeVo> bicycleType(){
        return bicycleService.bicycleType();
    }

}
