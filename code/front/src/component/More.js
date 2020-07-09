import React from "react";

export class More extends React.Component{
    constructor(props) {
        super(props);
        this.state={
            data:[]
        }
    }
    render() {
        return(<span>本网站由宇宙无敌帅气的UnicornTeamAreWe制作</span>)
    }
}
