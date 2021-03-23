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

        this.checkValidRefresh = this.checkValidRefresh.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick = () => {
        this.props.history.push("path/to/push");
    }

    checkValidRefresh() {
        this.handleClick(this);
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let b = cookies.get('username');



        if (b) {
            fetch('/api/user/get_user_info', {
                method: 'post',
                headers: new Headers({
                    'Authorization': 'Bearer ' + a,
                    'Content-Type': 'application/json'
                }),
                body: JSON.stringify({'username': cookies.get('username')})
            }).then(response => {
                if (!response.ok) {
                }
                return response.json()  //we only get here if there is no error
            })
        } else {
        }
    }

    componentDidMount() {
        this.checkValidRefresh()


    }

    handleRemoveCookie = () => {
        const { cookies } = this.props;
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