import React, {Component} from 'react';

import '../assets/css/Style.css';
import {Card, Table, Image, ButtonGroup, Button, InputGroup, FormControl} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faList, faEdit, faTrash, faStepBackward, faFastBackward, faStepForward, faFastForward, faSearch, faTimes} from '@fortawesome/free-solid-svg-icons';
import {Link} from 'react-router-dom';
import MyToast from './MyToast';
import axios from 'axios';



export default class User_Management extends React.Component{


    constructor(props) {
        super(props);
        this.state = {
            persons : [],
            search : '',
            currentPage : 1,
            personsPerPage : 5,
            sortDir: "asc"
        };
    }

    sortData = () => {
        this.state.sortDir === "asc" ? this.setState({sortDir: "desc"}) : this.setState({sortDir: "asc"});
        this.findAllPersons(this.state.currentPage);
    }

    componentDidMount() {
        this.findAllPersons(this.state.currentPage);
    }

    findAllPersons(currentPage) {
        currentPage -= 1;
        axios.get("http://localhost:8081/rest/persons/persons?pageNumber="+currentPage+"&pageSize="+this.state.sortDir)
            .then(response => response.data)
            .then((data) => {
                this.setState({
                    persons: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1
                });
            });
    };

    deletePerson = (personId) => {
        axios.delete("http://localhost:8081/rest/persons/"+personId)
            .then(response => {
                if(response.data != null) {
                    this.setState({"show":true});
                    setTimeout(() => this.setState({"show":false}), 3000);
                    this.setState({
                        persons: this.state.persons.filter(person => person.id !== personId)
                    });
                } else {
                    this.setState({"show":false});
                }
            });
    };

    changePage = event => {
        let targetPage = parseInt(event.target.value);
        if(this.state.search) {
            this.searchData(targetPage);
        } else {
            this.findAllPersons(targetPage);
        }
        this.setState({
            [event.target.name]: targetPage
        });
    };

    firstPage = () => {
        let firstPage = 1;
        if(this.state.currentPage > firstPage) {
            if(this.state.search) {
                this.searchData(firstPage);
            } else {
                this.findAllPersons(firstPage);
            }
        }
    };

    prevPage = () => {
        let prevPage = 1;
        if(this.state.currentPage > prevPage) {
            if(this.state.search) {
                this.searchData(this.state.currentPage - prevPage);
            } else {
                this.findAllPersons(this.state.currentPage - prevPage);
            }
        }
    };

    lastPage = () => {
        let condition = Math.ceil(this.state.totalElements / this.state.personsPerPage);
        if(this.state.currentPage < condition) {
            if(this.state.search) {
                this.searchData(condition);
            } else {
                this.findAllPersons(condition);
            }
        }
    };

    nextPage = () => {
        if(this.state.currentPage < Math.ceil(this.state.totalElements / this.state.personsPerPage)) {
            if(this.state.search) {
                this.searchData(this.state.currentPage + 1);
            } else {
                this.findAllPersons(this.state.currentPage + 1);
            }
        }
    };

    searchChange = event => {
        this.setState({
            [event.target.name] : event.target.value
        });
    };

    cancelSearch = () => {
        this.setState({"search" : ''});
        this.findAllPersons(this.state.currentPage);
    };

    searchData = (currentPage) => {
        currentPage -= 1;
        axios.get("http://localhost:8081/rest/persons/search/"+this.state.search+"?page="+currentPage+"&size="+this.state.personsPerPage)
            .then(response => response.data)
            .then((data) => {
                this.setState({
                    persons: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1
                });
            });
    };



    render(){
            const {persons, currentPage, totalPages, search} = this.state;

        return(
              <div >
                  <div style={{"display":this.state.show ? "block" : "none"}}>
                      <MyToast show = {this.state.show} message = {"Person Deleted Successfully."} type = {"danger"}/>
                  </div>
                  <Card className={"border border-dark bg-dark text-white"}>
                      <Card.Header>
                          <div style={{"float":"left"}}>
                              <FontAwesomeIcon icon={faList} /> Person List
                          </div>
                          <div style={{"float":"right"}}>
                               <InputGroup size="sm">
                                  <FormControl placeholder="Search" name="search" value={search}
                                      className={"info-border bg-dark text-white"}
                                      onChange={this.searchChange}/>
                                  <InputGroup.Append>
                                      <Button size="sm" variant="outline-info" type="button" onClick={this.searchData}>
                                          <FontAwesomeIcon icon={faSearch}/>
                                      </Button>
                                      <Button size="sm" variant="outline-danger" type="button" onClick={this.cancelSearch}>
                                          <FontAwesomeIcon icon={faTimes} />
                                      </Button>
                                  </InputGroup.Append>
                               </InputGroup>
                          </div>
                      </Card.Header>
                      <Card.Body>
                          <Table bordered hover striped variant="dark">
                              <thead>
                                  <tr>
                                    <th>Email</th>
                                    <th>Password</th>
                                    <th>Nome</th>
                                    <th>Description</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>Actions</th>
                                  </tr>
                                </thead>
                                <tbody>
                                  {
                                      persons.length === 0 ?
                                      <tr align="center">
                                        <td colSpan="7">No Person Available.</td>
                                      </tr> :
                                      persons.map((person) => (
                                      <tr key={person.id}>

                                          <td>{person.email}</td>
                                          <td>{person.password}</td>
                                          <td>{person.nome}</td>
                                          <td>{person.description}</td>
                                          <td>{person.type}</td>
                                          <td>{person.status}</td>
                                          <td>
                                              <ButtonGroup>
                                                  <Link to={"edit/"+person.id} className="btn btn-sm btn-outline-primary"><FontAwesomeIcon icon={faEdit} /></Link>{' '}
                                                  <Button size="sm" variant="outline-danger" onClick={this.deletePerson.bind(this, person.id)}><FontAwesomeIcon icon={faTrash} /></Button>
                                              </ButtonGroup>
                                          </td>
                                      </tr>
                                      ))
                                  }
                                </tbody>
                          </Table>
                      </Card.Body>
                      {persons.length > 0 ?
                          <Card.Footer>
                              <div style={{"float":"left"}}>
                                  Showing Page {currentPage} of {totalPages}
                              </div>
                              <div style={{"float":"right"}}>
                                  <InputGroup size="sm">
                                      <InputGroup.Prepend>
                                          <Button type="button" variant="outline-info" disabled={currentPage === 1 ? true : false}
                                              onClick={this.firstPage}>
                                              <FontAwesomeIcon icon={faFastBackward} /> First
                                          </Button>
                                          <Button type="button" variant="outline-info" disabled={currentPage === 1 ? true : false}
                                              onClick={this.prevPage}>
                                              <FontAwesomeIcon icon={faStepBackward} /> Prev
                                          </Button>
                                      </InputGroup.Prepend>
                                      <FormControl className={"page-num bg-dark"} name="currentPage" value={currentPage}
                                          onChange={this.changePage}/>
                                      <InputGroup.Append>
                                          <Button type="button" variant="outline-info" disabled={currentPage === totalPages ? true : false}
                                              onClick={this.nextPage}>
                                              <FontAwesomeIcon icon={faStepForward} /> Next
                                          </Button>
                                          <Button type="button" variant="outline-info" disabled={currentPage === totalPages ? true : false}
                                              onClick={this.lastPage}>
                                              <FontAwesomeIcon icon={faFastForward} /> Last
                                          </Button>
                                      </InputGroup.Append>
                                  </InputGroup>
                              </div>
                          </Card.Footer> : null
                       }
                  </Card>
              </div>
        );


    }
}