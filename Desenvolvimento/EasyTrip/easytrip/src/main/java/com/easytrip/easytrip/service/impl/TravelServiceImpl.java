package com.easytrip.easytrip.service.impl;

/*
@Service
public class TravelServiceImpl implements IService<Trip> {

    @Autowired
    private TripRepository travelRepository;

    @Override
    public Page<Trip> findAll(Pageable pageable, String searchText) {
        return travelRepository.findAllTravels(pageable, searchText);
    }

    @Override
    public Page<Trip> findAll(Pageable pageable) {
        return travelRepository.findAll(pageable);
    }

    @Override
    public Trip findById(Long id) {
        return travelRepository.findById(id).get();
    }

    @Override
    public Trip saveOrUpdate(Trip travel) {
        return travelRepository.save(travel);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            travelRepository.deleteById(id);
            jsonObject.put("message", "Trip deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

}
*/
