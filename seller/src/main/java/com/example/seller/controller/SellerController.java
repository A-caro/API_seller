package com.example.seller.controller;


import com.example.seller.entity.Seller;
import com.example.seller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping
    public List<Seller> getSellers(){
        return sellerService.getSellers();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Seller>> getSellerss(){
        return ResponseEntity.ok(sellerService.getSellers());
    }

    @GetMapping("/datos")
    public String getDatos(){
        return sellerService.getDatos();
    }


    @GetMapping("/{id}")
    public Optional<Seller> getClientById(@PathVariable Long id){
            return sellerService.findById(id);
    }
    @GetMapping("/other/{id}")
    public ResponseEntity<?> getSeller(@PathVariable ("id") Long id){
        try {
            Seller seller = sellerService.getSellerById(id);
            return ResponseEntity.ok(seller);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST + " " + "Seller inexsistente");
        }

    }

    @PostMapping("/create")
    public ResponseEntity<Seller> create(@RequestBody Seller seller){
      sellerService.createSeller(seller);
      return new ResponseEntity<Seller>(seller, null, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Seller> updateSeller(@RequestBody Seller seller){
        Seller seller1 = new Seller();
        try{
            seller1 = sellerService.updateSeller(seller);
            return ResponseEntity.ok(seller1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(seller1);
        }
    }

    @GetMapping("/names")
    public String getNames(){
        return sellerService.namesSellers();
    }

    @GetMapping("/namesS")
    public List<Seller> getNamesWithS(){
        return sellerService.listarNombresConC();

    }
}
