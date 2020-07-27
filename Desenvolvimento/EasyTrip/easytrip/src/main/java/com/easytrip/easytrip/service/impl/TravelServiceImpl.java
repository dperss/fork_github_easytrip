package com.easytrip.easytrip.service.impl;

/*
@Service
public class TravelServiceImpl implements IService<Travel> {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public Page<Travel> findAll(Pageable pageable, String searchText) {
        return travelRepository.findAllTravels(pageable, searchText);
    }

    @Override
    public Page<Travel> findAll(Pageable pageable) {
        return travelRepository.findAll(pageable);
    }

    @Override
    public Travel findById(Long id) {
        return travelRepository.findById(id).get();
    }

    @Override
    public Travel saveOrUpdate(Travel travel) {
        return travelRepository.save(travel);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            travelRepository.deleteById(id);
            jsonObject.put("message", "Travel deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

}
*/
