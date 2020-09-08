import React, {Component} from 'react';

import './../assets/css/Style.css';
import AuthService from "../services/auth/auth.service";





class Trip extends Component {

    constructor(props) {
        super(props);
        this.state = {
            redirect: null,
            userReady: false,
            currentUser: { username: "" },
            accommodations : [],
            points: []
        };
    }

    componentDidMount() {
        const currentUser = AuthService.getCurrentUser();
        this.setState({ currentUser: currentUser, userReady: true })
    }

    render() {
        const {accommodations, trips} = this.state;

        return (
            <div>

                <header>
                    <h1 className = "h1-prof"> A minha viagem</h1>
                </header>
                <main>

                </main>
            </div>
        );
    }
}


export default Trip;