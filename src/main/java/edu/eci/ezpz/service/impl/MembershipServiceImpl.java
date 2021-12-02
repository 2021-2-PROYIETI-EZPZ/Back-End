package edu.eci.ezpz.service.impl;

import com.google.gson.GsonBuilder;
import edu.eci.ezpz.controller.membership.IncomeResponse;
import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.exception.MemberShipNotFoundException;
import edu.eci.ezpz.repository.MembershipRepository;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.io.IOException;


@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository repository;

    @Value( "${CLIENTS_URI}" )
    private String uri;

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

    @Override
    public List<MemberShip> findAllPurchasedMembership() {
        List<MemberShip> memberShips = new ArrayList();
        Client[] res = getAllClients();
        for (Client c : res){
            if( c.getMemberShip() != null ){
                for(MemberShip m : c.getMemberShip()){
                    memberShips.add(m);
                }
            }
        }
        return memberShips;
    }

    @Override
    public List<MemberShip> filterAllMemberships(Date start, Date end) {
        List<MemberShip> answ = new ArrayList<MemberShip>();
        Client[] clients = getAllClients();
        for( Client c: clients ){
            if( c.getMemberShip() != null ){
                for( MemberShip m : c.getMemberShip() ){
                    if( m.getStartDate().after( start ) && m.getStartDate().before( end ) ){ answ.add(m); }
                }
            }
        }
        return answ;
    }

    @Override
    public IncomeResponse getIncome(Date start, Date end) {
        BigDecimal income = new BigDecimal(0);;
        Client[] clients = getAllClients();
        for( Client c: clients ){
            if( c.getMemberShip() != null ){
                for( MemberShip m : c.getMemberShip() ){
                    if( m.getStartDate().after( start ) && m.getStartDate().before( end ) ){ income = income.add(m.getPrice().getAmount()); }
                }
            }
        }

        return new IncomeResponse( start, end, "COP "+ income.toString());
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

    private Client[] getAllClients(){
        Client[] answ = null;
        try {
            URL obj = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
                answ = gson.fromJson( response.toString(), Client[].class );
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return answ;
    }

}
