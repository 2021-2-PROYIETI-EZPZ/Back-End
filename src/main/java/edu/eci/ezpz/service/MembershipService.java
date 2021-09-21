package edu.eci.ezpz.service;

import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.MemberShip;

import java.util.List;

public interface MembershipService {
    public MemberShip createMembership(MemberShip dto);
    public MemberShip findById(String id);

}
