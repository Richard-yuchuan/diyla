package com.cha102.diyla.back.controller.shop;

import com.cha102.diyla.commodityCommentModel.CommodityCommentService;
import com.cha102.diyla.commodityCommentModel.CommodityCommentVO;
import com.cha102.diyla.commodityModel.CommodityService;
import com.cha102.diyla.commodityModel.CommodityVO;
import com.cha102.diyla.member.MemVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class CommodityCommentController {

    private HttpSession session;
    private CommodityService commodityService = new CommodityService();
    private CommodityCommentService commodityCommentService;

    public CommodityCommentController(HttpSession session, CommodityCommentService commodityCommentService) {
        this.session = session;
        this.commodityCommentService = commodityCommentService;
    }

    @GetMapping("/commodityComment/get/{comNO}")
    @ResponseBody
    public List<CommodityCommentVO> findAllByComNo(@PathVariable Integer comNO) {
        return commodityCommentService.getAllByComNo(comNO);
    }

    @PostMapping("/commodityComment/delete/{commentId}")
    @ResponseBody
    public String deleteByComCommentNo(@PathVariable Integer comCommentNo) {
        commodityCommentService.deleteByComCommentNo(comCommentNo);
        return "success";
    }

}
