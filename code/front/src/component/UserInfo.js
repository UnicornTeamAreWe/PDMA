import React from "react";
import {Descriptions} from "antd";

export class UserInfo extends React.Component{
    constructor(props) {
        super(props);

        this.state={
            data:[]
        }
    }

    render() {
        return(
            <Descriptions title="User Info">
                <Descriptions.Item label="UserName">{this.props.user.username}</Descriptions.Item>
                <Descriptions.Item label="E-mail">{this.props.user.email}</Descriptions.Item>
            </Descriptions>
        )
    }
}
