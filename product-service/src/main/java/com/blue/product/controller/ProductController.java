package com.blue.product.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.common.domain.Product;
import com.example.common.domain.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blue.product.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
    private static Logger log= LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping(path = "/findProduct={id}")
    public ResultMap findProduct(@PathVariable("id") Long id, HttpServletRequest request) {
        ResultMap result = ResultMap.createResultMap();
        try {
            Product product = productService.findById(id);
            product.setName(product.getName()+" from "+request.getRemoteAddr()+":"+request.getServerPort());
            result.setTransport(product);
        } catch (Exception e) {
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @GetMapping("allProduct")
    public ResultMap allProduct() {
        ResultMap result = ResultMap.createResultMap();
        try {
            log.info("invoke productService.findAll()");
            List<Product> list = productService.findAll();
            result.setTransport(list);
        } catch (Exception e) {
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @GetMapping("findByUser")
    public ResultMap findByUser(@RequestParam("uid")Long uid) {
        ResultMap result = ResultMap.createResultMap();
        try {
            log.info("invoke productService.findByUser");
            List<Product> list = productService.findByUser(uid);
            result.setTransport(list);
        } catch (Exception e) {
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }

//    @PostMapping("saveProduct")
//    public ResultMap saveProduct(@RequestBody Product product) {
//        ResultMap result = ResultMap.createResultMap();
//        try {
//            productService.save(product);
//        } catch (Exception e) {
//            result.setCode("0");
//            result.setMsg(e.getMessage());
//        }
//        return result;
//    }
    
    @PostMapping("saveProduct")
    public ResultMap saveProduct(@RequestBody Map<String,Object> product) {
    	ResultMap result = ResultMap.createResultMap();
    	try {
    		productService.save(product);
    	} catch (Exception e) {
    		result.setCode("0");
    		result.setMsg(e.getMessage());
    		throw e;
    	}
    	return result;
    }

    @PostMapping("updateProduct")
    public ResultMap updateProduct(Product product) {
        ResultMap result = ResultMap.createResultMap();
        try {
            productService.update(product);
        } catch (Exception e) {
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @DeleteMapping(path = "/deleteProduct={id}")
    public ResultMap deleteProduct(@PathVariable("id") Long id) {
        ResultMap result = ResultMap.createResultMap();
        try {
            productService.delete(id);
        } catch (Exception e) {
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }

}
