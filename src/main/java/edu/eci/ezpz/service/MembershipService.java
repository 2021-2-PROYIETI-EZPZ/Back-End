package edu.eci.ezpz.service;

import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.MemberShip;

import java.util.Date;
import java.util.List;

public interface MembershipService {
    public List<MemberShip> findAllMemberShips();
    public MemberShip createMembership(MemberShip dto);
    public MemberShip findById(String id);
    public MemberShip updateMemberShip( MemberShip ms, String id );
    public boolean deleteById( String id );
    public List<MemberShip> findAllPurchasedMembership();
    public List<MemberShip> filterAllMemberships(Date start, Date end);

}
