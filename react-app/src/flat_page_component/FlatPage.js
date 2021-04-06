import React, {Component, useRef} from 'react';
import './FlatPage.css';
import Header from "../Header";
import Cookies from "universal-cookie";

import MuiImageSlider from 'mui-image-slider';

// Import Swiper React components
import { Swiper, SwiperSlide } from 'swiper/react';

// Import Swiper styles
import 'swiper/swiper.scss';

class FlatPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            images: ["/fggf/gf/c"],
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        };

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

    async componentDidMount() {
        let flat = this.getFlat();
        flat.then(res => this.setState({
            country:res.country,
            town:res.town,
            street:res.street,
            houseNom:res.houseNom,
            floor:res.floor,
            price:res.price,
            description:res.description,
            ownerId:res.ownerID,
            images:res.images
        }));
    }


    render() {
        const { price, country, town, street, houseNom, images, description } = this.state;

        return (

            <div>
                <Header />

                <div className='container-main'>

                    <div className='main-window-left'>
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
                        <div className='price-container'>
                            {price} рублей
                        </div>

                        <br />
                        <div className='show-phone-container'>
                            <button className='show-phone' >
                                <span className='phone-button-text'>Показать контакты</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default FlatPage;