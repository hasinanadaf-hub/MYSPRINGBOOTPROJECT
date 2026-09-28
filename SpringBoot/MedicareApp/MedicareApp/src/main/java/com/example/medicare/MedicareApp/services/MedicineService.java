package com.example.medicare.MedicareApp.services;

import com.example.medicare.MedicareApp.entities.Medicine;
import com.example.medicare.MedicareApp.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService
{
    @Autowired
    private MedicineRepository medicineRepository;

    public Medicine addMedicine(Medicine medicine)
    {
        List<Medicine> list = medicineRepository.findAll();
        for (Medicine m :list)
        {
            if(m.getName().equalsIgnoreCase(medicine.getName()))
            {
                throw new RuntimeException("Medicine ALready Exists");
            }
        }
      return  medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicines()
      {
        return medicineRepository.findAll();
    }
  public Medicine updateMedicine(Long id ,Medicine medicine)
  {
      Optional<Medicine> optmedicine = medicineRepository.findById(id);
      if(optmedicine.isPresent())
      {
          Medicine existingmed = optmedicine.get();
          if(medicine.getName() !=null)
              existingmed.setName(medicine.getName());
          if(medicine.getCategory()!=null)
              existingmed.setCategory(medicine.getCategory());
          if(medicine.getPrice()!= 0)
              existingmed.setPrice(medicine.getPrice());
          if(medicine.getDescription()!=null)
              existingmed.setDescription(medicine.getDescription());
          if(medicine.getImage() != null)
              existingmed.setImage(medicine.getImage());
          return medicineRepository.save(existingmed);
      }
      else
      {
          throw new RuntimeException("Medicine not Found");
      }
  }
  public  List<Medicine> getMedicineByCategory(String category)
  {
      return  medicineRepository.findAll()
              .stream()
              .filter(m->m.getCategory().equalsIgnoreCase(category))
              .toList();
  }
}
