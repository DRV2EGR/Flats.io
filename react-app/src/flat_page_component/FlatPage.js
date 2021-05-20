import React, {Component, useRef} from 'react';
import './FlatPage.css';
import Header from "../Header";
import Cookies from "universal-cookie";

import MuiImageSlider from 'mui-image-slider';

// Import Swiper React components
import { Swiper, SwiperSlide } from 'swiper/react';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faCoffee, faHeart} from '@fortawesome/free-solid-svg-icons';

// Import Swiper styles
import 'swiper/swiper.scss';
import {Preloader, TailSpin} from "react-preloader-icon";

class FlatPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            button_style:'show-phone-button',
            phone_style:'hidden',
            email_style:'hidden',
            lbl_style:'hidden',

            loading:true,
            main_container:'hidden',

            images: ["/fggf/gf/c"],
            awatar_rieltor:'',
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error',
            liked:false
        };

        this.showContacts = this.showContacts.bind(this);
        this.likepanelret = this.likepanelret.bind(this);
        this.handleSetLike = this.handleSetLike.bind(this);

    }



    async getFlat() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        return await fetch('/api/flats/get_flat?id=' + this.props.match.params.flatId, {
            method: 'get',
            headers: new Headers({
                'Authorization': 'Bearer ' + a,
                'Content-Type': 'application/json'
            })
        }).then(response => {
            if (!response.ok) {
                // this.checkValidRefresh();
                window.location.reload();
            }
            return response.json();
        });
    }

    async getUser(credentials) {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        return await fetch('/api/user/public/get_user_info', {
            method: 'post',
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

    async getUserAwatar() {

        return await fetch('/api/user/public/get_user_img_url_by_username?username=' + this.state.ownerUsername, {
            method: 'get',
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        }).then(response => {
            if (!response.ok) {
                // this.checkValidRefresh();
                window.location.reload();
            }
            return response.json();
        });
    }

    async componentDidMount() {
        await this.getFlat().then((res) => {this.setState({
            country:res.country,
            town:res.town,
            street:res.street,
            houseNom:res.houseNom,
            floor:res.floor,
            price:res.price,
            description:res.description,
            ownerId:res.ownerID,
            images:res.images,
            ownerUsername:res.ownerUsername,
            id:res.id
        })});

        let username = this.state.ownerUsername;
        let user = await this.getUser({username});
        this.setState({
            firstName: user.firstName,
            secondName: user.secondName,
            lastName: user.lastName,
            email: user.email,
            phoneNumber: user.phoneNumber,
            role: user.role
        });

        await this.getUserAwatar().then(res => this.setState({
            awatar_rieltor:res.img
        }))

        if (this.state.awatar_rieltor === '') {
            this.setState({
                awatar_rieltor:'https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg'
            });
        }

        const cookies = new Cookies();
        let ap = cookies.get('accessToken');
        let bp = cookies.get('username');
        if (bp) {
            this.frt().then(res=>{
                this.setState({likes:res.length})
                res.forEach(
                    el => {
                        if (bp == el.user.username) {
                            this.setState({liked:true})
                        }
                    }
                )
            });
        } else {
            this.frt().then(res => this.setState({likes: res.length}));
        }

        this.setState({main_container:'container-main', loading:false})
    }

    showContacts() {
        this.setState({
            button_style:'hidden',
            phone_style:'phone-number-text',
            email_style:'email-text',
            lbl_style:'text-with-phone'
        });
    }

    async frt() {
        return await fetch('/api/flats/get_likes_to_flat_by_id?id=' + this.state.id, {
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

    handleSetLike() {
        const cookies = new Cookies();
        let ap = cookies.get('accessToken');
        let bp = cookies.get('username');
        if (ap) {
            fetch('/api/user/public/set_like_to_flat' , {
                method: 'post',
                headers: new Headers({
                    'Authorization': 'Bearer ' + ap,
                    'Content-Type': 'application/json'
                }),
                body: JSON.stringify({'id_to': this.state.id})
            }).then(response => response.json())
                .then(res => /*console.log(result.imgUrl) );*/ this.setState({user_image: res.img}));
        }

        this.setState({likes:true,liked:"red"})
    }

    likepanelret() {
        let likes;
        // Promise.resolve(this.frt()).then(res => likes=res);
        // console.log(likes);

        if (this.state.liked) {
            return (
                <div>
                    <button className="button" >
                        {/*<i className="fas fa-heart fa-lg" style={{color: "red"}}></i>*/}
                        <FontAwesomeIcon icon={faHeart} size="1x" style={{color: "red"}}/> {this.state.likes}
                    </button>
                </div>
            );
        } else {
            return (
                <div>
                    <button
                        className="button"
                        onClick={this.handleSetLike}
                    >
                        {/*<i className="fas fa-heart fa-lg" style={{color: "red"}}></i>*/}
                        <FontAwesomeIcon icon={faHeart} size="1x" style={{color: this.state.liked}}/> {this.state.likes}
                    </button>
                </div>
            );
        }
    }

    render() {
        const { price, country, town, street,
                    houseNom, images, description,
                    firstName, secondName, lastName,
                    email, phoneNumber, role,
                    button_style, phone_style, email_style, lbl_style,
                    awatar_rieltor, ownerId, ownerUsername,
                    loading, main_container } = this.state;

        return (

            <div>
                <Header />

                {loading ? <div className='centerred-loader'><Preloader
                    use={TailSpin}
                    size={200}
                    strokeWidth={6}
                    strokeColor="#262626"
                    duration={2000}
                /></div> : <div></div> }

                <div className={main_container}>

                    <div className='main-window-left'>
                        <span>вчера, 11:17</span>
                        <div className='rooms-container'>
                            n - комн. квартира, 56,4 м²
                        </div>
                        <br />
                        <div className='adress-container'>
                            {country}, город {town}, {street}
                            <br />
                            дом {houseNom}
                        </div>

                        <br />
                        <div className='options-order-pallete'>
                            {this.likepanelret()}
                        </div>

                        <div className='photoes-conteiner'>
                            <MuiImageSlider
                                images={images}
                                // fitToImageHeight={true}
                            />

                            {/*<Swiper*/}
                            {/*    spaceBetween={50}*/}
                            {/*    slidesPerView={3}*/}
                            {/*    navigation*/}
                            {/*    pagination={{ clickable: true }}*/}
                            {/*    scrollbar={{ draggable: true }}*/}
                            {/*    onSwiper={(swiper) => console.log(swiper)}*/}
                            {/*    onSlideChange={() => console.log('slide change')}*/}
                            {/*>*/}
                            {/*    <SwiperSlide><img src='http://img-fotki.yandex.ru/get/9300/102699435.9d8/0_b88f4_8fa30144_L.jpg' /></SwiperSlide>*/}
                            {/*    <SwiperSlide>Slide 2</SwiperSlide>*/}
                            {/*    <SwiperSlide>Slide 3</SwiperSlide>*/}
                            {/*    <SwiperSlide>Slide 4</SwiperSlide>*/}
                            {/*    ...*/}
                            {/*</Swiper>*/}
                        </div>

                        <div className='description-container'>
                            <p>{description}</p>
                        </div>

                    </div>
                    <div className='main-window-right'>
                        <div className='main-window-right-section'>
                            <div className='price-container'>
                                {price} рублей
                            </div>
                            <p className='text_with_price'>Альтернатива, возможна ипотека</p>

                            <br />
                            <div className='show-phone-container'>
                                <button className={button_style} onClick={this.showContacts} >
                                    <span className='phone-button-text'>Показать контакты</span>
                                </button>

                                <span className={phone_style}>{phoneNumber}</span>
                                <span className={email_style}>{email}</span>
                                <p className={lbl_style}>Пожалуйста, скажите, что нашли это объявление на Flats.io. И оставьте отзыв после звонка</p>
                            </div>
                        </div>

                        <div className='main-window-right-section'>
                            <a href={'/user/'+ownerUsername}>
                                <div className='right-secton-devider'>
                                    <div>
                                        <h4>Продавец:</h4>
                                        <p className='sailer-text'>{firstName} {secondName}</p>
                                        <br />
                                        <p className='rieltor-date-registreation'>На сайте с 2003 года</p>
                                    </div>
                                    <div>
                                        <img className='rieltor-awatar' src={awatar_rieltor} />
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default FlatPage;