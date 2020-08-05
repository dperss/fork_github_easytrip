package com.easytrip.easytrip.resource.impl;

/*
@RestController
@RequestMapping("/travels")
@CrossOrigin(origins="http://localhost:3000")
public class TravelResourceImpl implements Resource<Trip> {

    @Autowired
    private IService<Trip> travelIService;

    @Override
    public ResponseEntity<Page<Trip>> findAll(Pageable pageable, String searchText) {
        return new ResponseEntity<>(travelIService.findAll(pageable, searchText), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<Trip>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return new ResponseEntity<>(travelIService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Trip> findById(Long id) {
        return new ResponseEntity<>(travelIService.findById(id), HttpStatus.OK);

    }


    @Override
    public ResponseEntity<Trip> save(Trip travel) {
        return new ResponseEntity<>(travelIService.saveOrUpdate(travel), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Trip> update(Trip travel) {
        return new ResponseEntity<>(travelIService.saveOrUpdate(travel), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return new ResponseEntity<>(travelIService.deleteById(id), HttpStatus.OK);
    }

}
*/