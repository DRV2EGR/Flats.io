import React, {Component, useRef} from 'react';
import './FlatPage.css';
import Header from "../Header";
import Cookies from "universal-cookie";

import MuiImageSlider from 'mui-image-slider';

// Import Swiper React components
import { Swiper, SwiperSlide } from 'swiper/react';

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
            description: props.description ? props.description : 'Unknown error'
        };

        this.showContacts = this.showContacts.bind(this);
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
            ownerUsername:res.ownerUsername
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


    render() {
        const { price, country, town, street,
                    houseNom, images, description,
                    firstName, secondName, lastName,
                    email, phoneNumber, role,
                    button_style, phone_style, email_style, lbl_style,
                    awatar_rieltor, ownerId,
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
                            LIKE PANEL
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
                            <a href={'/user/'+ownerId}>
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