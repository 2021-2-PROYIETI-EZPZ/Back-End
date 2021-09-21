package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.service.MembershipService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class MembershipServiceImpl implements MembershipService {
    private final HashMap<String, MemberShip> hashMemberShip = new HashMap();
    @Override
    public MemberShip createMembership(MemberShip dto) {
        hashMemberShip.put(dto.getCodeMembership(),dto);
        return dto;
    }
    @Override
    public MemberShip findById(String id) {
        MemberShip member = hashMemberShip.get(id);
        return member;
    }

}
