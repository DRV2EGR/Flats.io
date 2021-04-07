//ToDo: RealtorsPage.js
import React, {Component} from 'react';
import Cookies from "universal-cookie";

class RealtorsPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            page : []
        }
    }

    async getAllRieltors(credentials) {
        return await fetch('/api/user/public/get_all_realtors', {
            method: 'get',
            headers: new Headers({
                'Content-Type': 'application/json'
            }),
            body:JSON.stringify(credentials)
        }).then(response => {
            if (!response.ok) {
                // this.checkValidRefresh();
                window.location.reload();
            }
            return response.json();
        });
    }

    async getUserAwatar(username) {

        return await fetch('/api/user/public/get_user_img_url_by_username?username=' + username, {
            method: 'get',
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        }).then(response => {
            if (!response.ok) {
                // this.checkValidRefresh();
                //window.location.reload();
            }
            return response.json();
        });
    }



    async componentDidMount() {
        const lemma = [];

        await this.getAllRieltors().then(async (res) => {

            for (let i = 0; i < res.length; ++i) {
                await this.getUserAwatar(res[i].username).then(img_url => res[i].img_url = img_url)

                await lemma.push(
                    <div>
                        {res[i].firstName}
                    </div>
                );

                console.log('pushed');
            }

            console.log(lemma);
        });

        this.setState(
            {page : lemma}
        );


        // let user = await this.getUser({username});
        // this.setState({
        //     firstName: user.firstName,
        //     secondName: user.secondName,
        //     lastName: user.lastName,
        //     email: user.email,
        //     phoneNumber: user.phoneNumber,
        //     role: user.role
        // });
        //
        // await this.getUserAwatar().then(res => this.setState({
        //     awatar_rieltor:res.img
        // }))
        //
        // if (this.state.awatar_rieltor === '') {
        //     this.setState({
        //         awatar_rieltor:'https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg'
        //     });
        // }
        //
        // this.setState({main_container:'container-main', loading:false})
    }

    render() {
        const {page} = this.state;

        return (
            <div>
                {page}
            </div>
        );
    }
}

export default RealtorsPage;