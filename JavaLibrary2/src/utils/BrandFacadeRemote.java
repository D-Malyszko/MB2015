/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Brand;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface BrandFacadeRemote {

    void create(Brand brand);

    void edit(Brand brand);

    void remove(Brand brand);

    Brand find(Object id);

    List<Brand> findAll();

    List<Brand> findRange(int[] range);

    int count();
    
}
