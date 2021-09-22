package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.exception.MemberShipNotFoundException;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.service.MembershipService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {
    private final HashMap<String, MemberShip> hashMemberShip = new HashMap();

    @Override
    public List<MemberShip> findAllMemberShips() { return new ArrayList<>( hashMemberShip.values() ); }

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

    @Override
    public MemberShip updateMemberShip(MemberShip ms, String id) {
        deleteById( id );
        return createMembership( ms );
    }

    @Override
    public boolean deleteById(String id) {
        if( hashMemberShip.containsKey( id ) ){ hashMemberShip.remove( id ); }
        else{ throw new MemberShipNotFoundException(); }
        return true;
    }


}
