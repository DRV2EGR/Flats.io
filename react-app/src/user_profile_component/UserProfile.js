import React, { Component } from 'react';
import Header from '../Header';
import './nullStyle.css';
import '../rieltors_page_component/RealtorPage.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import './UserProfile.css';
import Cookies from "universal-cookie";
import CheckAcsessComponent from "../CheckAcsessComponent";
import {Preloader, TailSpin} from "react-preloader-icon";
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';
import 'react-tabs/style/react-tabs.css';
import AwesomeSlider from "react-awesome-slider";


class UserProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            main_container:'hidden',
            loading: true
            // code: props.code ? props.code : '999',
            // description: props.description ? props.description : 'Unknown error'
        }
    }

    async makeReplyes() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        return await fetch('/api/user/public/get_comments_to_user_by_id?id=' + this.state.id, {
            method: 'get',
            headers: new Headers({
                'Authorization': 'Bearer ' + a,
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
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let b = cookies.get('username');

        if (this.props.match.params.username != null) {
            b = this.props.match.params.username;
        }

        if (b) {

            await fetch('/api/user/public/get_user_img_url_by_username?username=' + b, {
                method: 'post',
                headers: new Headers({
                    'Authorization': 'Bearer ' + a,
                    'Content-Type': 'application/json'
                }),
                body: JSON.stringify({'username': b})
            }).then(response => response.json())
                .then(res => /*console.log(result.imgUrl) );*/ this.setState({user_image: res.img}));

            await fetch('/api/user/public/get_user_info', {
                method: 'post',
                headers: new Headers({
                    'Authorization': 'Bearer ' + a,
                    'Content-Type': 'application/json'
                }),
                body: JSON.stringify({'username': b})
            }).then(response => response.json())
                .then(res => /*console.log(result.imgUrl) );*/ {
                    this.setState({
                        phoneNumber: res.phoneNumber,
                        firstName: res.firstName,
                        secondName: res.secondName,
                        lastName: res.lastName,
                        username: res.username,
                        email: res.email,
                        role: res.role,
                    });
                    if (this.state.role == 'ROLE_ADMIN') {
                        this.setState({role: 'Администратор'});
                    } else if (this.state.role == 'ROLE_SELLER') {
                        this.setState({role: 'Собственник'});
                    } else if (this.state.role == 'ROLE_REALTOR') {
                        this.setState({role: 'Риелтор'});
                    } else if (this.state.role == 'ROLE_USER') {
                        this.setState({role: 'Пользователь'});
                    }
                });

            await fetch('/api/user/public/get_user_info', {
                method: 'post',
                headers: new Headers({
                    'Authorization': 'Bearer ' + a,
                    'Content-Type': 'application/json'
                }),
                body: JSON.stringify({'username': b})
            }).then(response => response.json())
                .then(res => /*console.log(result.imgUrl) );*/ {
                        this.setState({
                            id: res.id,
                            phoneNumber: res.phoneNumber,
                            firstName: res.firstName,
                            secondName: res.secondName,
                            lastName: res.lastName,
                            username: res.username,
                            email: res.email,
                            role: res.role,
                        });
                        if (this.state.role == 'ROLE_ADMIN') {
                            this.setState({role: 'Администратор'});
                        } else if (this.state.role == 'ROLE_SELLER') {
                            this.setState({role: 'Собственник'});
                        } else if (this.state.role == 'ROLE_REALTOR') {
                            this.setState({role: 'Риелтор'});
                        } else if (this.state.role == 'ROLE_USER') {
                            this.setState({role: 'Пользователь'});
                        }
                    }
                );

            const lemma = [];

            await this.makeReplyes().then(async (res) => {

                console.log(res);
                this.setState({
                    summa: res.length
                });

                for (let i = 0; i < res.length; ++i) {
                    //await this.getUserAwatar(res[i].username).then(img_url => res[i].img_url = img_url)

                    await console.log(res[i]);

                    let erase = [];
                    if (res[i].img_from.img == "") {
                        await erase.push(
                            <div>
                                <img src='https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg'
                                     className='realtor-avatar poabs'/>
                                <div className='realtor-avatar-div'>
                                <span className='realtor-avatar-letter'>
                                    {res[i].user_from.firstName.charAt(0)}
                                </span>
                                </div>
                            </div>
                        );
                    } else {
                        await erase.push(
                            <img src={res[i].img_from.img} className='realtor-avatar'/>
                        );
                    }

                    let rating_com = [];

                    for (let j = 0; j < 5; ++j) {
                        if (j < res[i].rating) {
                            rating_com.push(
                                <li className='df'>
                                    <svg data-name="Star" xmlns="http://www.w3.org/2000/svg" width="100%"
                                         height="100%" viewBox="0 0 20 18">
                                        <defs>
                                            <linearGradient id="12596888-0" y2="0%" x2="100%" y1="0%" x1="0%">
                                                <stop offset="0%" stop-opacity="1" stop-color="#ff7e00"></stop>
                                                <stop offset="100%" stop-opacity="1"
                                                      stop-color="#ff7e00"></stop>
                                                <stop offset="100%" stop-opacity="0"
                                                      stop-color="#ff7e00"></stop>
                                                <stop offset="100%" stop-opacity="1"
                                                      stop-color="#ff7e00"></stop>
                                                <stop offset="100%" stop-opacity="1"
                                                      stop-color="#ff7e00"></stop>
                                            </linearGradient>
                                        </defs>
                                        <path stroke="url(#12596888-0)" fill="url(#12596888-0)"
                                              d="M15.214 17.176l-.996-5.805 4.218-4.112-5.83-.847L10 1.13 7.393 6.412l-5.83.847 4.219 4.112-.996 5.805L10 14.436l5.214 2.74z">

                                        </path>
                                    </svg>
                                </li>
                            );
                        } else {
                            rating_com.push(
                                <li>
                                    <svg data-name="Star" xmlns="http://www.w3.org/2000/svg" width="100%"
                                         height="100%" viewBox="0 0 20 18">
                                        <defs>
                                            <linearGradient id="12596888-3" y2="0%" x2="100%" y1="0%" x1="0%">
                                                <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                <stop offset="0%" stop-opacity="0" stop-color="#e8e9ec"></stop>
                                                <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                <stop offset="100%" stop-opacity="1"
                                                      stop-color="#e8e9ec"></stop>
                                            </linearGradient>
                                        </defs>
                                        <path stroke="url(#12596888-3)" fill="url(#12596888-3)"
                                              d="M15.214 17.176l-.996-5.805 4.218-4.112-5.83-.847L10 1.13 7.393 6.412l-5.83.847 4.219 4.112-.996 5.805L10 14.436l5.214 2.74z">

                                        </path>
                                    </svg>
                                </li>
                            );
                        }
                    }

                    await lemma.push(
                        // <div>
                        //     {res[i].firstName}
                        // </div>
                        // <a href={'/user/' + res[i].id}>
                            <div className='realtor-container'>
                                <div className='realtor-credentials tap-realtor-peace right-zero nwarp'>
                                    <div className='warp'>
                                        <div className='realtor-avatar-container'>
                                            {erase}
                                        </div>
                                        <div>
                                            <span className='realtor-fio-cred'>{res[i].user_from.firstName} {res[i].user_from.secondName}</span>

                                            {/*<div className='realtor-fio-descr'>*/}
                                            {/*    {res[i].user_from.role}*/}
                                            {/*</div>*/}
                                        </div>
                                    </div>

                                    <div className='realtor-review tap-realtor-peace dff rierw'>
                                        <ui>
                                            {/*Оценка: <li> {res[i].rating}</li>*/}

                                            {rating_com}
                                        </ui>
                                    </div>
                                </div>

                                <div className="cmt-mn">

                                    <div className='realtor-objects tap-realtor-peace comment-main cm-mn'>
                                        <div>
                                            {/*<span className='nomber-of-objects-big'>N объектов</span> <br/>*/}
                                            {/*<span style={{marginLeft: '10px'}}>в работе</span>*/}

                                            <p className="rew-txt">{res[i].comment}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        // </a>
                    );

                    // console.log('pushed');
                }

                console.log(lemma);
            });

            this.setState(
                {page: lemma}
            );

            this.setState({main_container: 'container-main', loading: false})
        }
    }


    render() {
        const { username, user_image, phoneNumber,
                firstName, secondName,lastName,
                email, role,
                loading, main_container, page, summa } = this.state;
        // const {code, description} = this.state;
        return (

            <div className="mdv">
                <Header/>

                {loading ? <div className='centerred-loader'><Preloader
                    use={TailSpin}
                    size={200}
                    strokeWidth={6}
                    strokeColor="#262626"
                    duration={2000}
                /></div> : <div></div> }

                <div className={main_container}>
                {/*<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"/>*/}
            <div className="container bootstrap snippets bootdeys">
                <div className="row" id="user-profile">


                    <div className="col-lg-3 col-md-4 col-sm-4">
                        <div className="main-box clearfix">
                            <h2>{username} </h2>
                            <div className="profile-status">
                                <i className="fa fa-check-circle"></i> Онлайн
                            </div>
                            <img src={user_image}
                                alt="" className="profile-img img-responsive center-block"/>
                            <div className="profile-label">
                                <span className="label label-success">{role}</span>
                            </div>

                            {/*<div className="profile-stars">*/}
                            {/*    <i className="fa fa-star"></i>*/}
                            {/*    <i className="fa fa-star"></i>*/}
                            {/*    <i className="fa fa-star"></i>*/}
                            {/*    <i className="fa fa-star"></i>*/}
                            {/*    <i className="fa fa-star"></i>*/}
                            {/*    <br/><span>Professional Investor</span>*/}
                            {/*</div>*/}
                            <div className="profile-stars">
                                {/*<span className="label label-warning">hr</span>*/}
                                {/*<span className="label label-primary">digital</span>*/}
                                {/*<span className="label label-danger">pr</span>*/}

                            </div>
                            <div className="profile-since">
                                На сайте с: Фев 2021
                            </div>

                            <div className="profile-details">
                                <ul className="fa-ul">
                                    <li><i className="fa-li fa fa-comment"></i>Комментарии: <span>{summa}</span></li>
                                    {this.props.match.params.username ? "" :
                                        <li><i className="fa-li fa fa-tasks"></i>Лайки: <span>110</span></li>
                                    }
                                </ul>
                            </div>

                        </div>
                    </div>

                    <div className="col-lg-9 col-md-8 col-sm-8">
                        <div className="main-box clearfix">
                            <div className="profile-header">
                                <h3><span>Информация о пользователе</span></h3>

                            </div>

                            <div className="row profile-user-info">
                                <div className="col-sm-8">
                                    <div className="profile-user-details clearfix">
                                        <div className="profile-user-details-label">
                                            Имя
                                        </div>
                                        <div className="profile-user-details-value">
                                            {firstName}
                                        </div>
                                    </div>

                                    <div className="profile-user-details clearfix">
                                        <div className="profile-user-details-label">
                                            Фамилия
                                        </div>
                                        <div className="profile-user-details-value">
                                            {secondName}
                                        </div>
                                    </div>

                                    <div className="profile-user-details clearfix">
                                        <div className="profile-user-details-label">
                                            Номер
                                        </div>
                                        <div className="profile-user-details-value">
                                            {phoneNumber}
                                        </div>
                                    </div>

                                    <div className="profile-user-details clearfix">
                                        <div className="profile-user-details-label">
                                            Email
                                        </div>
                                        <div className="profile-user-details-value">
                                            {email}
                                        </div>
                                    </div>

                                </div>
                                <div className="col-sm-4 profile-social">
                                    <ul className="fa-ul">
                                        {/*Определение соц.сетей пользователя.*/}
                                        {/*<li><i className="fa-li fa fa-twitter-square"></i><a href="#">@pavelinvest</a></li>*/}
                                        {/*<li><i className="fa-li fa fa-skype"></i><a href="#">money_more</a></li>*/}
                                        {/*<li><i className="fa-li fa fa-instagram"></i><a href="#">business_investor</a></li>*/}
                                    </ul>
                                </div>
                            </div>


                            <div className="tbs-mn">
                                <Tabs>
                                    <TabList>
                                        <Tab>Отзывы о пользователе</Tab>
                                        {this.props.match.params.username ? "" :
                                            <Tab>Понравившиеся квартиры</Tab>  }
                                    </TabList>

                                    <TabPanel>
                                        <div className="repl-container">
                                            {/*<div className="repl-main">*/}
                                            {/*    <div className="mar">*/}
                                            {/*        <div className="repl-avatar-div">*/}
                                            {/*            <img src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/i/b561dc28-505f-426f-8a59-abec46161744/dbscvr2-c1a5e06a-2375-4dca-b7a0-8700279f9cbb.png/v1/fill/w_894,h_894,strp/sefsef_x_unnamed_by_cyacol_dbscvr2-pre.png" className='realtor-avatar' />*/}
                                            {/*        </div>*/}
                                            {/*    </div>*/}
                                            {/*</div>*/}

                                            {page}
                                        </div>
                                    </TabPanel>

                                    {this.props.match.params.username ? "" :
                                        <TabPanel>
                                            <div className="likes-main">
                                                <div className="liked-flat">
                                                    <AwesomeSlider animation="cubeAnimation">
                                                        {mappedImgs}
                                                    </AwesomeSlider>
                                                </div>
                                            </div>
                                        </TabPanel>
                                    }
                                </Tabs>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
                </div>
            {/*<script src="http://code.jquery.com/jquery-1.10.2.min.js"/>*/}
            {/*<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>*/}
            </div>
        );
    }
}

export default UserProfile;