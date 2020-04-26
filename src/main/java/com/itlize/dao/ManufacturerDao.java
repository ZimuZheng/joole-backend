package com.itlize.dao;

import com.itlize.entity.Manufacturer;

public interface ManufacturerDao {

    // C
    void addManufacturer(Manufacturer manufacturer);

    // R
    Manufacturer getManufacturerById(Long mid);

    // U
    void updateManufacturer(Manufacturer manufacturer);

    // D
    void deleteManufacturer(Manufacturer manufacturer);
}
