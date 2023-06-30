package com.example.membership.controller;

import com.example.membership.contrants.Result;
import com.example.membership.data.vo.ResponseVo;
import com.example.membership.data.vo.member.MemberVo;
import com.example.membership.data.vo.member.SaveRequestVo;
import com.example.membership.membership.model.Member;
import com.example.membership.service.MemberService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public ResponseVo<List<MemberVo>> findAll() {
        List<MemberVo> memberVoList = this.memberService.findAll().stream().map(x -> {
                    return modelMapper.map(x, MemberVo.class);
                }
        ).toList();
        log.info(memberVoList.toString());

        return ResponseVo.<List<MemberVo>>builder().status(HttpStatus.OK.value()).data(memberVoList).build();
    }

    @PostMapping
    public ResponseVo<Void> save(@Valid @RequestBody SaveRequestVo saveRequestVo) {
        log.info(saveRequestVo.toString());
        Member member = modelMapper.map(saveRequestVo, Member.class);
        log.info(member.toString());
        this.memberService.save(member);
        return ResponseVo.<Void>builder().status(HttpStatus.OK.value()).message(Result.SAVE_SUCCESS).build();
    }

}
