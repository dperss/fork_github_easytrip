import React, {Component} from 'react';

import {connect} from 'react-redux';
import {deletePoint} from './../services/index';

import './../assets/css/Style.css';
import {Card, Table, ButtonGroup, Button, InputGroup, FormControl} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {
    faList,
    faEdit,
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


class PointList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            points : [],
            search : '',
            currentPage : 1,
            pointsPerPage : 5,
            sortDir: "asc"
        };
    }

    sortData = () => {
        setTimeout(() => {
            this.state.sortDir === "asc" ? this.setState({sortDir: "desc"}) : this.setState({sortDir: "asc"});
            this.findAllPoints(this.state.currentPage);
        }, 500);
    };

    componentDidMount() {
        this.findAllPoints(this.state.currentPage);

    }


    findAllPoints(currentPage) {
        currentPage -= 1;
        axios.get("http://localhost:8080/api/test/point_of_interests?pageNumber="+currentPage+"&pageSize="+this.state.pointsPerPage+"&sortBy=id&sortDir="+this.state.sortDir)
            .then(response => response.data)
            .then((data) => {
                this.setState({
                    points: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1
                });
            });
    };


    deletePoint = (pointId) => {
        this.props.deletePoint(pointId);
        setTimeout(() => {
            if(this.props.pointObject != null) {
                this.setState({"show":true});
                setTimeout(() => this.setState({"show":false}), 3000);
                this.findAllPoints(this.state.currentPage);
            } else {
                this.setState({"show":false});
            }
        }, 1000);

    };

    changePage = event => {
        let targetPage = parseInt(event.target.value);
        if(this.state.search) {
            this.searchData(targetPage);
        } else {
            this.findAllPoints(targetPage);
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
                this.findAllPoints(firstPage);
            }
        }
    };

    prevPage = () => {
        let prevPage = 1;
        if(this.state.currentPage > prevPage) {
            if(this.state.search) {
                this.searchData(this.state.currentPage - prevPage);
            } else {
                this.findAllPoints(this.state.currentPage - prevPage);
            }
        }
    };

    lastPage = () => {
        let condition = Math.ceil(this.state.totalElements / this.state.pointsPerPage);
        if(this.state.currentPage < condition) {
            if(this.state.search) {
                this.searchData(condition);
            } else {
                this.findAllPoints(condition);
            }
        }
    };

    nextPage = () => {
        if(this.state.currentPage < Math.ceil(this.state.totalElements / this.state.pointsPerPage)) {
            if(this.state.search) {
                this.searchData(this.state.currentPage + 1);
            } else {
                this.findAllPoints(this.state.currentPage + 1);
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
        this.findAllPoints(this.state.currentPage);
    };

    searchData = (currentPage) => {
        currentPage -= 1;
        axios.get("http://localhost:8080/api/test/point_of_interests/search/name/{searchText}?searchText=" + this.state.search)
            .then(response => response.data)
            .then((data) => {
                this.setState({
                    points: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1
                });
            });
    };

    render() {
        const {points, currentPage, totalPages, search} = this.state;

        return (
            <div>
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast show = {this.state.show} message = {"Point of interest Deleted Successfully."} type = {"success"}/>
                </div>
                <Card className={"border border-light bg-light text-dark"}>
                    <Card.Header>
                        <div style={{"float":"left"}}>
                            <FontAwesomeIcon icon={faList} /> Lista de Pontos
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
                                <th>Tipo de Ponto</th>
                                <Link to={"add/"} className = "btn btn-sm btn-outline-info"> <FontAwesomeIcon icon={faPlus}/></Link>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                points.length === 0 ?
                                    <tr align="center">
                                        <td colSpan="7">No Point of interest Available.</td>
                                    </tr> :
                                    points.map((point) => (
                                        <tr key={point.id}>
                                            <td>{point.name}</td>
                                            <td>{point.location_nome}</td>
                                            <td>{point.description}</td>
                                            <td>{point.type_of_point}</td>
                                            <td>
                                                <ButtonGroup>
                                                    <Link to={"edit/"+point.id} className="btn btn-sm btn-outline-info"><FontAwesomeIcon icon={faEdit} /></Link>{' '}
                                                    <Button size="sm" variant="outline-danger" onClick={this.deletePoint.bind(this, point.id)}><FontAwesomeIcon icon={faTrash} /></Button>
                                                </ButtonGroup>
                                            </td>
                                        </tr>
                                    ))
                            }
                            </tbody>
                        </Table>
                    </Card.Body>
                    {points.length > 0 ?
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
        pointObject: state.point
    };
};

const mapDispatchToProps = dispatch => {
    return {
        deletePoint: (pointId) => dispatch(deletePoint(pointId))
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(PointList);