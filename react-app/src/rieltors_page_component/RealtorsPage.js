//ToDo: RealtorsPage.js
import React, {Component} from 'react';
import Cookies from "universal-cookie";
import Header from "../Header";
import './RealtorPage.css';
import {Preloader, TailSpin} from "react-preloader-icon";
import Box from "@material-ui/core/Box";
import Rating from "@material-ui/lab/Rating";

import { DateTimeLocale } from 'dt-format';
import {rudString} from "rud";

class RealtorsPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            page : [],
            summa : 0,
            loading : true,
            ishidden : 'hidden'
        }
    }

    async getAllRieltors(credentials) {
        return await fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/user/public/get_all_realtors', {
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

        return await fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/user/public/get_user_img_url_by_username?username=' + username, {
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

    async makeReplyes(id) {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        return await fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/user/public/get_comments_to_user_by_id?id=' + id, {
            method: 'get',
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        }).then(response => {
            if (!response.ok) {
                // this.checkValidRefresh();
                // window.location.reload();
            }
            return response.json();
        });
    }

    async getAdditInf(id) {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        return await fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/user/public/get_additional_info_about_realtor?id=' + id, {
            method: 'get',
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        }).then(response => {
            if (!response.ok) {
                // this.checkValidRefresh();
                // window.location.reload();
            }
            return response.json();
        });
    }

    async componentDidMount() {
        const lemma = [];

        await this.getAllRieltors().then(async (res) => {

            this.setState({
                summa:res.length
            });

            for (let i = 0; i < res.length; ++i) {
                await this.getUserAwatar(res[i].username).then(img_url => res[i].img_url = img_url)

                let dateFrom = new Date(res[i].dateUserFrom);
                let frm = (rudString(dateFrom.getFullYear().toString() + ("0" + (dateFrom.getMonth() + 1)).slice(-2)));
                frm = frm.slice(2);

                let comnoma = 0;
                await this.makeReplyes(res[i].id).then(async (res) => comnoma = res.length);

                let numFlts = 0;
                await this.getAdditInf(res[i].id).then(async (res) => numFlts = res);
                console.log('f', numFlts)

                await console.log(res[i]);

                if (res[i].role == "ROLE_REALTOR") {
                    res[i].role = "Риелтор";
                }

                let erase = [];
                if (res[i].img_url.img == "") {
                    await erase.push(
                        <div>
                            <img src='https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg'
                            className='realtor-avatar poabs' />
                            <div className='realtor-avatar-div'>
                                <span className='realtor-avatar-letter'>
                                    {res[i].firstName.charAt(0)}
                                </span>
                            </div>
                        </div>
                    );
                } else {
                    await erase.push(
                        <img src={res[i].img_url.img} className='realtor-avatar' />
                    );
                }

                await lemma.push(
                    // <div>s
                    //     {res[i].firstName}
                    // </div>
                    <a href={'/user/'+res[i].username}>
                        <div className='realtor-container'>
                            <div className='realtor-credentials tap-realtor-peace'>
                                <div className='realtor-avatar-container'>
                                    {erase}
                                </div>
                                <div>
                                    <span className='realtor-fio-cred'>{res[i].firstName} {res[i].secondName}</span>

                                    <div className='realtor-fio-descr'>
                                        {res[i].role}
                                    </div>
                                    <div className='realtor-fio-descr'>
                                        на сайте с: {frm}
                                    </div>
                                </div>

                            </div>
                            <div className='realtor-review tap-realtor-peace dff'>

                                <Box component="fieldset" mb={3} borderColor="transparent">
                                    <Rating name="read-only" value={res[i].rating} readOnly />
                                </Box>

                                <div>
                                    <span className='review-count-text'>{comnoma} отзывов</span>
                                </div>
                            </div>
                            <div className='realtor-objects tap-realtor-peace'>
                                <div>
                                    <span className='nomber-of-objects-big'>{numFlts} объектов</span> <br />
                                    <span style={{marginLeft : '10px'}}>в работе</span>
                                </div>
                            </div>
                        </div>
                    </a>
                );

                // console.log('pushed');
            }

            // console.log(lemma);
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
        this.setState({
            loading:false,
            ishidden:''
        });
    }

    render() {
        const {page, summa, loading, ishidden} = this.state;

        return (
            <div>
                <Header />

                {loading ? <div className='m-md-auto cent'><Preloader
                    use={TailSpin}
                    size={200}
                    strokeWidth={6}
                    strokeColor="#262626"
                    duration={2000}
                /></div> : <div></div>}

                    <div className={ishidden}>
                    <h3>Риелторы для вас</h3>
                    <span className='summary'>Найдено {summa} риелторов</span>
                    <br /><br />
                    <div className='main-container'>


                        {page}

                    </div>
                </div>

            </div>
        );
    }
}

export default RealtorsPage;