import React, {Component} from 'react';
import Header from "../Header";

import './AboutStyle.css';

class AboutPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }
    }

    render() {
        return (
            <div className="mn">
                <Header />

                <div className="main-cnt">
                    <h1>О нас</h1>
                </div>
                <div>
                   <h3> Разработчики: </h3>
                    <p>
                        <h2>1.Рогов Дмитрий <br /><br />
                            1.1.Витухина наталья </h2>
                    </p>
                </div>
            </div>
        );
    }
}

export default AboutPage;