package com.example.seller.service;

import com.example.seller.entity.Client;
import com.example.seller.entity.Seller;
import com.example.seller.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;


    public Optional<Seller> findById(Long id){
        return sellerRepository.findById(id);

    }

    public Seller getSellerById(Long id) throws Exception{
        return sellerRepository.findById(id).orElseThrow(
                () -> new Exception("No existe un Seller con " + id)
        );
    }

   public Seller createSeller(Seller seller){
       return sellerRepository.save(seller);
   }
    public List<Seller> getSellers(){
        return  sellerRepository.findAll();
    }

    public Seller updateSeller(Seller seller) throws Exception{
        Seller updateById = sellerRepository.findById(seller.getId()).orElseThrow(
                () -> new Exception("No existe el Seller que intentas actualizar " + seller.getId()));
        updateById.setId(seller.getId());
        updateById.setName(seller.getName());
        updateById.setProductos(seller.getProductos());
        updateById.setPrecioProducto(seller.getPrecioProducto());
        return sellerRepository.save(seller);
   }

               //***************Practica con lambda***********
    public String getDatos(){
        List<Seller> sellers = sellerRepository.findAll();
        return sellers.stream().map(s -> s.getProductos() + " , " + s.getPrecioProducto()).collect(Collectors.joining("\n"));
    }

    public String namesSellers(){
        List<Seller> sellerList = sellerRepository.findAll();
        return sellerList.stream().map(Seller::getName).collect(Collectors.joining(" - "));
    }

    public List<Seller> listarNombresConC(){
        List<Seller> sellerList = sellerRepository.findAll();
        return sellerList.stream().filter(s -> s.getName().charAt(0) == 'C').collect(Collectors.toList());

    }


   public String findClientByInvoice(String nameClient){

   }


}
