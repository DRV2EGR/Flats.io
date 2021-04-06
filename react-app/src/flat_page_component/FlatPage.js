import React, {Component, useRef} from 'react';


class FlatPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        };

    }




    render() {

        return (


            <div>

            </div>
        );
    }

}

export default FlatPage;