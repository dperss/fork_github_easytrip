import React, {Component} from "react";
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css';
import Pagination from "../components/Pagination";
import AccommodationCard from "./AccommodationCard";
import axios from 'axios';
import {connect} from "react-redux";





class Accommodation extends Component {
    state = {
        allAccommodations: [],
        currentAccommodations: [],
        currentPage: null,
        totalPages: null
    };

    componentDidMount(currentPage) {
        currentPage -=1;

        axios.get("http://localhost:8080/api/test/accomodations?pageNumber=0&pageSize=4&sortBy=name&sortDir=asc")
            .then(res => {
                const allAccommodations = res.data;
                console.log(res.data);
                this.setState({ allAccommodations});
            });

    }

    onPageChanged = data => {
        const { allAccommodations } = this.state;
        const { currentPage, totalPages, pageLimit } = data;

        const offset = (currentPage - 1) * pageLimit;
        const currentAccommodation = allAccommodations.toString().slice(offset, offset + pageLimit);

        this.setState({ currentPage, currentAccommodation, totalPages });
    };

    render() {
        const {
            allAccommodations,
            currentAccommodation,
            currentPage,
            totalPages
        } = this.state;
        const totalAccommodation = allAccommodations.length;

        if (totalAccommodation === 0) return null;

        const headerClass = [
            "text-dark py-2 pr-4 m-0",
            currentPage ? "border-gray border-right" : ""
        ]
            .join(" ")
            .trim();

        return (
            <div className="container mb-5">
                <div className="row d-flex flex-row py-5">
                    <div className="w-100 px-4 py-5 d-flex flex-row flex-wrap align-items-center justify-content-between">
                        <div className="d-flex flex-row align-items-center">
                            <h2 className={headerClass}>
                                <strong className="text-secondary">{totalAccommodation}</strong>{" "}
                                Accommodations
                            </h2>
                            {currentPage && (
                                <span className="current-page d-inline-block h-100 pl-4 text-secondary">
                  Page <span className="font-weight-bold">{currentPage}</span> /{" "}
                                    <span className="font-weight-bold">{totalPages}</span>
                </span>
                            )}
                        </div>
                        <div className="d-flex flex-row py-4 align-items-center">
                            <Pagination
                                totalRecords={4}
                                pageLimit={5}
                                pageNeighbours={1}
                                onPageChanged={this.onPageChanged}
                            />
                        </div>
                    </div>
                    {[currentAccommodation].map(accommodation => (
                        <AccommodationCard />
                    ))}
                </div>
            </div>
        );
    }
}

export default connect(AccommodationCard)(Accommodation);