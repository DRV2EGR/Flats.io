import './App.css';
import React, {Component, useRef} from 'react';
import Cookies from "universal-cookie";
import {withCookies} from "react-cookie";
import PropTypes, { instanceOf } from "prop-types";
import {withRouter} from "react-router";

class CheckAcsessComponent extends Component {
    static propTypes = {
        cookies: instanceOf(Cookies).isRequired
    };

    constructor(props) {
        super(props);
        this.state = {
        };

        this.checkValidAccess = this.checkValidAccess.bind(this);
        this.checkValidRefresh = this.checkValidRefresh.bind(this);

        this.handleRemoveCookie = this.handleRemoveCookie.bind(this);

        this.goToAuth = this.goToAuth.bind(this);
        this.checkPageForRedirectToLogin = this.checkPageForRedirectToLogin.bind(this);
    }

    goToAuth = () => {
        this.props.history.push("/login");
    }

    checkPageForRedirectToLogin = () => {
        let current_location = window.location.pathname;
        let protectedUrls = ['/user_profile', '/user_settings', '/add_order'];

        if (protectedUrls.indexOf( current_location ) !== -1) {
            this.goToAuth();
        }
    }

    checkValidRefresh() {
        const cookies = new Cookies();
        let a = cookies.get('refreshToken');

        if (a) {
            try {
                console.log("DETECTED REFRESH");

                fetch('/api/user/public/get_user_info', {
                    method: 'post',
                    headers: new Headers({
                        'Authorization': 'Bearer ' + a,
                        'Content-Type': 'application/json'
                    }),
                    body: JSON.stringify({'refreshToken': cookies.get('refreshToken')})
                }).then(response => {
                    if (!response.ok) {
                        this.handleRemoveCookie();
                        this.checkPageForRedirectToLogin();
                    }
                    return response.json()  //we only get here if there is no error
                })
                    .then(res => this.setState({
                        username: res.username,
                        accessToken: res.accessToken,
                        refreshToken: res.refreshToken
                    }))

                this.handleRemoveCookie();
                cookies.set('accessToken', this.state.accessToken, {path: '/'});
                cookies.set('refreshToken', this.state.refreshToken, {path: '/'});
                cookies.set('username', this.state.username, {path: '/'});
            } catch (e) {
                this.handleRemoveCookie();
                this.checkPageForRedirectToLogin();
            }
        } else {
            this.handleRemoveCookie();
            this.checkPageForRedirectToLogin();
        }
    }

    checkValidAccess() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let b = cookies.get('username');



        if (a) {
            try {
                console.log("DETECTED ACCESS");

                fetch('/api/user/public/get_user_info', {
                    method: 'post',
                    headers: new Headers({
                        'Authorization': 'Bearer ' + a,
                        'Content-Type': 'application/json'
                    }),
                    body: JSON.stringify({'username': cookies.get('username')})
                }).then(response => {
                    if (!response.ok) {
                        this.checkValidRefresh();
                    }
                    return response.json()  //we only get here if there is no error
                })
            } catch (e) {
                this.checkValidRefresh();
            }
        } else {
            this.checkValidRefresh();
        }
    }

    componentDidMount() {
        this.checkValidAccess()
    }

    handleRemoveCookie = () => {
        const cookies = new Cookies();
        cookies.remove("username"); // remove the cookie
        cookies.remove("accessToken"); // remove the cookie
        cookies.remove("refreshToken"); // remove the cookie
        // this.setState({ user: cookies.get("user") });
    };


    render() {

        return (
           <div>

           </div>
        );
    }

}

export default (withRouter)(CheckAcsessComponent);