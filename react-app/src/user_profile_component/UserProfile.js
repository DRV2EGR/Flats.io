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
import Typography from "@material-ui/core/Typography";
import Box from '@material-ui/core/Box';
import Rating from '@material-ui/lab/Rating';
import {TextField} from "@material-ui/core";
import { sizing } from '@material-ui/system';
import Button from "@material-ui/core/Button";
import {rudString} from "rud";


class UserProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            main_container:'hidden',
            loading: true,
            cmttext: '',

            mappedImgs: [],

            stars: 0
            // code: props.code ? props.code : '999',
            // description: props.description ? props.description : 'Unknown error'
        }

        this.renderFlats = this.renderFlats.bind(this);
        this.givecmtsection = this.givecmtsection.bind(this);
        this.handleSetComment = this.handleSetComment.bind(this);

    }

    async makeReplyes() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        return await fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/user/public/get_comments_to_user_by_id?id=' + this.state.id, {
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

    async makeLikedFlats() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        return await fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/user/public/get_likes_from_user_by_id?id=' + this.state.id, {
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

            await fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/user/public/get_user_img_url_by_username?username=' + b, {
                method: 'post',
                headers: new Headers({
                    'Authorization': 'Bearer ' + a,
                    'Content-Type': 'application/json'
                }),
                body: JSON.stringify({'username': b})
            }).then(response => response.json())
                .then(res => /*console.log(result.imgUrl) );*/ this.setState({user_image: res.img}));



            await fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/user/public/get_user_info', {
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
                            dt: res.dateUserFrom
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

            let dateFrom = new Date(this.state.dt);
            let frmo = (rudString(dateFrom.getFullYear().toString() + ("0" + (dateFrom.getMonth() + 1)).slice(-2)));
            frmo = frmo.slice(2);

            this.setState({frm:frmo});

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

                    rating_com.push(
                        <Box component="fieldset" mb={3} borderColor="transparent">
                            <Rating name="read-only" value={res[i].rating} readOnly />
                        </Box>
                    );

                    // for (let j = 0; j < 5; ++j) {
                    //     if (j < res[i].rating) {
                    //         rating_com.push(
                    //             <li className='df'>
                    //                 <svg data-name="Star" xmlns="http://www.w3.org/2000/svg" width="100%"
                    //                      height="100%" viewBox="0 0 20 18">
                    //                     <defs>
                    //                         <linearGradient id="12596888-0" y2="0%" x2="100%" y1="0%" x1="0%">
                    //                             <stop offset="0%" stop-opacity="1" stop-color="#ff7e00"></stop>
                    //                             <stop offset="100%" stop-opacity="1"
                    //                                   stop-color="#ff7e00"></stop>
                    //                             <stop offset="100%" stop-opacity="0"
                    //                                   stop-color="#ff7e00"></stop>
                    //                             <stop offset="100%" stop-opacity="1"
                    //                                   stop-color="#ff7e00"></stop>
                    //                             <stop offset="100%" stop-opacity="1"
                    //                                   stop-color="#ff7e00"></stop>
                    //                         </linearGradient>
                    //                     </defs>
                    //                     <path stroke="url(#12596888-0)" fill="url(#12596888-0)"
                    //                           d="M15.214 17.176l-.996-5.805 4.218-4.112-5.83-.847L10 1.13 7.393 6.412l-5.83.847 4.219 4.112-.996 5.805L10 14.436l5.214 2.74z">
                    //
                    //                     </path>
                    //                 </svg>
                    //             </li>
                    //         );
                    //     } else {
                    //         rating_com.push(
                    //             <li>
                    //                 <svg data-name="Star" xmlns="http://www.w3.org/2000/svg" width="100%"
                    //                      height="100%" viewBox="0 0 20 18">
                    //                     <defs>
                    //                         <linearGradient id="12596888-3" y2="0%" x2="100%" y1="0%" x1="0%">
                    //                             <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                    //                             <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                    //                             <stop offset="0%" stop-opacity="0" stop-color="#e8e9ec"></stop>
                    //                             <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                    //                             <stop offset="100%" stop-opacity="1"
                    //                                   stop-color="#e8e9ec"></stop>
                    //                         </linearGradient>
                    //                     </defs>
                    //                     <path stroke="url(#12596888-3)" fill="url(#12596888-3)"
                    //                           d="M15.214 17.176l-.996-5.805 4.218-4.112-5.83-.847L10 1.13 7.393 6.412l-5.83.847 4.219 4.112-.996 5.805L10 14.436l5.214 2.74z">
                    //
                    //                     </path>
                    //                 </svg>
                    //             </li>
                    //         );
                    //     }
                    //  }

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

            if (this.props.match.params.username == null) {
                await this.makeLikedFlats().then(async (res) => {
                    const _flats = res;
                    console.log('likes', _flats);
                    this.setState({ flats: [..._flats], likes_summ: [..._flats].length  });
                });
            }

            this.setState({main_container: 'container-main', loading: false})
        }
    }


    renderFlats() {

        const userList = [];

        let k = 0;
        try {
            k = this.state.flats.length;
        } catch (e) {
            k = 0;
        }

        // Проход по листу квартир
        for(let i = 0; i < k; i++) {
            // let name = `${this.state.flats_p[i].name.first} ${this.state.flats_p[i].name.last}`;
            let country = this.state.flats[i].flat.country;
            let town = this.state.flats[i].flat.town;
            let street = this.state.flats[i].flat.street;
            let houseNom = this.state.flats[i].flat.houseNom;
            let floor = this.state.flats[i].flat.floor;
            let price = this.state.flats[i].flat.price;
            let description = this.state.flats[i].flat.description;

            let id = this.state.flats[i].flat.id;

            let images = this.state.flats[i].flat.images;
            let mappedImgs = images.map((image) =>
                <div data-src={image} key={Math.random()} />
            );



            userList.push(
                <div className="liked-flat">
                    <AwesomeSlider animation="cubeAnimation" className="aws-sl">
                        {mappedImgs}
                    </AwesomeSlider>

                    <a href={'flat/'+id}  className='main-a'>
                        <div className='my-div'>
                            <h3 className='font-weight-bold lead'>Цена: {price}</h3>

                            <p className='lead'>Улица: {street} <br />
                                Дом: {houseNom}</p>
                        </div>
                    </a>
                </div>

            );
        }


        return userList;
    }

    handleSetComment() {
        const cookies = new Cookies();
        let ap = cookies.get('accessToken');
        let bp = cookies.get('username');
        if (this.state.stars != 0) {
            fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/user/public/set_comment_to_user' , {
                method: 'post',
                headers: new Headers({
                    'Authorization': 'Bearer ' + ap,
                    'Content-Type': 'application/json'
                }),
                body: JSON.stringify({'id_to': this.state.id,'commentText': this.state.cmttext, 'rating':this.state.stars})
            }).then(response => response.json())
                .then(res => /*console.log(result.imgUrl) );*/ this.setState({user_image: res.img}));
        }

        window.location.reload();
    }

    givecmtsection() {
        const cookies = new Cookies();
        let ap = cookies.get('accessToken');
        let bp = cookies.get('username');

        if (bp) {
            return (
                <div>
                    <h3>Напишите отзыв!</h3>
                    <div className='repl-cmt-main'>
                        <Box component="fieldset" mb={3} borderColor="transparent">
                            <Rating
                                name="simple-controlled"
                                value={this.state.stars}
                                onChange={(event, newValue) => {
                                    this.setState({stars:newValue});
                                }}
                            />

                        </Box>
                        <div className='repl-cmt-text'>
                            <TextField
                                id="filled-multiline-static"
                                label="Текст комментария"
                                multiline
                                variant="filled"
                                width="auto"
                                style ={{width: '100%'}}
                                onChange={(event, value) => this.setState({cmttext: event.target.value})}
                            />
                        </div>
                    </div>
                    <div className='repl-cmt-button'>
                        <Button
                            variant="contained"
                            color="primary"
                            onClick={this.handleSetComment}
                        >
                            Отправить отзыв
                        </Button>
                    </div>
                </div>
            );
        } else {
           return ( <div className='repl-cmt-main'>
               <h4>Войдите, чтобы написать отзыв!</h4>
           </div> );
        }
    }

    render() {
        const { username, user_image, phoneNumber,
                firstName, secondName,lastName,
                email, role,
                loading, main_container, page, summa,
                likes_summ, frm } = this.state;
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
                            {user_image?
                                <img src={user_image}
                                     alt="" className="profile-img img-responsive center-block"/>:
                                <img src="https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg"
                                     alt="" className="profile-img img-responsive center-block"/>
                            }

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
                                На сайте с: {frm}
                            </div>

                            <div className="profile-details">
                                <ul className="fa-ul">
                                    <li><i className="fa-li fa fa-comment"></i>Комментарии: <span>{summa}</span></li>
                                    {this.props.match.params.username ? "" :
                                        <li><i className="fa-li fa fa-tasks"></i>Лайки: <span>{likes_summ}</span></li>
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

                                            {this.givecmtsection()}
                                        </div>
                                    </TabPanel>

                                    {this.props.match.params.username ? "" :
                                        <TabPanel>
                                            <div className="likes-main">
                                                {this.renderFlats()}
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