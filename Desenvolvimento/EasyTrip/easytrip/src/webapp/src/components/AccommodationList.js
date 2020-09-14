import React, {Component} from 'react';

import {connect} from 'react-redux';
import {deleteAccommodation} from './../services/indexAccommodation';

import './../assets/css/Style.css';
import {Card, Table, ButtonGroup, Button, InputGroup, FormControl} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {
    faList,
    faTrash,
    faStepBackward,
    faFastBackward,
    faStepForward,
    faFastForward,
    faSearch,
    faTimes,
    faPlus
} from '@fortawesome/free-solid-svg-icons';
import {Link} from 'react-router-dom';
import MyToast from './MyToast';
import axios from 'axios';




class AccommodationList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            accommodations : [],
            search : '',
            currentPage : 1,
            accommodationsPerPage : 5,
            sortDir: "asc"
        };
    }

    sortData = () => {
        setTimeout(() => {
            this.state.sortDir === "asc" ? this.setState({sortDir: "desc"}) : this.setState({sortDir: "asc"});
            this.findAllAccommodations(this.state.currentPage);
        }, 500);
    };

    componentDidMount() {
        this.findAllAccommodations(this.state.currentPage);

    }


    findAllAccommodations(currentPage) {
        currentPage -= 1;
        axios.get(" http://localhost:8080/api/test/accomodations?pageNumber="+currentPage+"&pageSize="+this.state.accommodationsPerPage+"&sortBy=id&sortDir="+this.state.sortDir)
            .then(response => response.data)
            .then((data) => {
                this.setState({
                    accommodations: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1
                });
            });
    };


    deleteAccommodation = (accommodationId) => {
        this.props.deleteAccommodation(accommodationId);
        setTimeout(() => {
            if(this.props.accommodationObject != null) {
                this.setState({"show":true});
                setTimeout(() => this.setState({"show":false}), 3000);
                this.findAllAccommodations(this.state.currentPage);
            } else {
                this.setState({"show":true});
                setTimeout(() => this.setState({"show":false}), 3000);
                this.findAllAccommodations(this.state.currentPage);
            }
        }, 1000);

    };


    changePage = event => {
        let targetPage = parseInt(event.target.value);
        if(this.state.search) {
            this.searchData(targetPage);
        } else {
            this.findAllAccommodations(targetPage);
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
                this.findAllAccommodations(firstPage);
            }
        }
    };

    prevPage = () => {
        let prevPage = 1;
        if(this.state.currentPage > prevPage) {
            if(this.state.search) {
                this.searchData(this.state.currentPage - prevPage);
            } else {
                this.findAllAccommodations(this.state.currentPage - prevPage);
            }
        }
    };

    lastPage = () => {
        let condition = Math.ceil(this.state.totalElements / this.state.accommodationsPerPage);
        if(this.state.currentPage < condition) {
            if(this.state.search) {
                this.searchData(condition);
            } else {
                this.findAllAccommodations(condition);
            }
        }
    };

    nextPage = () => {
        if(this.state.currentPage < Math.ceil(this.state.totalElements / this.state.accommodationsPerPage)) {
            if(this.state.search) {
                this.searchData(this.state.currentPage + 1);
            } else {
                this.findAllAccommodations(this.state.currentPage + 1);
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
        this.findAllAccommodations(this.state.currentPage);
    };

    searchData = (currentPage) => {
        currentPage -= 1;
        axios.get(" http://localhost:8080/api/test/accomodations/search/name/{searchText}?searchText=" + this.state.search)
            .then(response => response.data)
            .then((data) => {
                this.setState({
                    accommodations: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1
                });
            });
    };

    render() {

        const {accommodations, currentPage, totalPages, search} = this.state;

        return (
            <div>
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast show = {this.state.show} message = {"Ajomamento eliminado com sucesso!"} type = {"success"}/>
                </div>
                <Card className={"border border-light bg-light text-dark"}>
                    <Card.Header>
                        <div style={{"float":"left"}}>
                            <FontAwesomeIcon icon={faList} /> Lista de Alojamentos
                        </div>
                        <div style={{"float":"right"}}>
                            <InputGroup size="sm">
                                <FormControl placeholder="Procurar.." name="search" value={search}
                                             className={"info-border bg-light text-dark"}
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
                        <Table bordered hover striped variant="light">
                            <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Localização</th>
                                <th>Descrição</th>
                                <th>Preço</th>
                                <Link to={"addAccommodation/"} className = "btn btn-sm btn-outline-info"> <FontAwesomeIcon icon={faPlus}/></Link>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                accommodations.length === 0 ?
                                    <tr align="center">
                                        <td colSpan="7">No Accommodation Available.</td>
                                    </tr> :
                                    accommodations.map((accommodation) => (
                                        <tr key={accommodation.id}>
                                            <td>{accommodation.name}</td>
                                            <td>{accommodation.location}</td>
                                            <td>{accommodation.description}</td>
                                            <td>{accommodation.price}</td>
                                            <td>
                                                <ButtonGroup>
                                                    <Button size="sm" variant="outline-danger" onClick={this.deleteAccommodation.bind(this, accommodation.id)}><FontAwesomeIcon icon={faTrash} /></Button>
                                                </ButtonGroup>
                                            </td>
                                        </tr>
                                    ))
                            }
                            </tbody>
                        </Table>
                    </Card.Body>
                    {accommodations.length > 0 ?
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
                                    <FormControl className={"page-num bg-light"} name="currentPage" value={currentPage}
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

const mapStateToProps = state => {
    return {
        accommodationObject: state.accommodations
    };
};

const mapDispatchToProps = dispatch => {
    return {
        deleteAccommodation: (accommodationId) => dispatch(deleteAccommodation(accommodationId))
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(AccommodationList);