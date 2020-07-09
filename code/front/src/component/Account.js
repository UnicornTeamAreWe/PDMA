import React from "react";

export class Account extends React.Component{
    constructor(props) {
        super(props);

        this.state={
            data:[]
        }
    }

    render() {
        return(<span>此处应有账号授权</span>)
    }
}
