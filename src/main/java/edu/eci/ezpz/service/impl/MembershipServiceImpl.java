package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.exception.MemberShipNotFoundException;
import edu.eci.ezpz.repository.MembershipRepository;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository repository;

    @Override
    public List<MemberShip> findAllMemberShips() {
        return repository.findAll();
    }

    @Override
    public MemberShip createMembership(MemberShip dto) {
        dto.setCodeMembership(generateId());
        return repository.save( dto );
    }

    @Override
    public MemberShip findById(String id) {
        Optional<MemberShip> op = repository.findById(id);
        if(! op.isPresent()){ throw new MemberShipNotFoundException(); }
        return op.get();
    }

    @Override
    public MemberShip updateMemberShip(MemberShip ms, String id) {
        ms.setCodeMembership( findById(id).getCodeMembership() );
        return repository.save(ms);
    }

    @Override
    public boolean deleteById(String id) {
        findById(id);
        repository.deleteById(id);
        return true;
    }


    private String generateId(){
        List<MemberShip> memberShips = findAllMemberShips();
        int biggest = 0;
        for( MemberShip m : memberShips ){
            int num = Integer.parseInt(m.getCodeMembership().split("_")[1]);
            if( biggest < num ) { biggest = num; }
        }
        return "MEM_"+String.valueOf(biggest + 1);
    }


}
