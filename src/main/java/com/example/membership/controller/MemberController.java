package com.example.membership.controller;

import com.example.membership.data.vo.member.MemberVo;
import com.example.membership.data.vo.member.MemberVoR;
import com.example.membership.data.vo.ResponseVo;
import com.example.membership.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    private final ModelMapper modelMapper;

    @Autowired
    public MemberController(MemberService memberService, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseVo<List<MemberVoR>> findAll() {
        List<MemberVoR> memberVoList = this.memberService.findAll().stream().map(x -> {
                    return modelMapper.map(x, MemberVoR.class);
                }
        ).toList();
        log.info(memberVoList.toString());

        return ResponseVo.<List<MemberVoR>>builder().status(HttpStatus.OK.value()).data(memberVoList).build();
    }

    @GetMapping("/123")
    public String save() {


        return "123";
    }

}
