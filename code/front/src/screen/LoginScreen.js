import React from "react";
import {Form, Input, Button, Checkbox, Col, Row} from "antd";

const layout = {
    labelCol: {span: 8},
    wrapperCol: {span: 16},
};
const tailLayout = {
    wrapperCol: {offset: 8, span: 16},
};

export class LoginScreen extends React.Component {
    constructor(props) {
        super(props);
        this.state = {

        }
    }

    onFinish = values => {
        console.log('Success:', values);
    };

    onFinishFailed = errorInfo => {
        console.log('Failed:', errorInfo);
    };

    render() {
        return (
            <div
                style={{
                    height: 827,
                    width: '100%',
                    backgroundImage: "url(" + require("../002.jpg") + ")",
                    backgroundSize: 'cover',
                    backgroundPosition: "center"
                }}
            >
                <Row>
                    <Col span={8}/>
                    <Col span={8}>
                        <Form
                            {...layout}
                            name="basic"
                            initialValues={{remember: true}}
                            onFinish={this.onFinish}
                            onFinishFailed={this.onFinishFailed}
                            style={{
                                backgroundColor: "white",
                                padding: 25,
                                position: 'center',
                                marginTop:200,
                                borderRadius:25,
                            }}
                        >
                            <Form.Item
                                label="Username"
                                name="username"
                                rules={[{required: true, message: 'Please input your username!'}]}
                            >
                                <Input/>
                            </Form.Item>

                            <Form.Item
                                label="Password"
                                name="password"
                                rules={[{required: true, message: 'Please input your password!'}]}
                            >
                                <Input.Password/>
                            </Form.Item>

                            <Form.Item {...tailLayout} name="remember" valuePropName="checked">
                                <Checkbox>Remember me</Checkbox>
                            </Form.Item>

                            <Form.Item {...tailLayout}>
                                <Button type="primary" htmlType="submit">
                                    Submit
                                </Button>
                            </Form.Item>
                        </Form>
                    </Col>
                    <Col span={8}/>
                </Row>
            </div>
        )
    }
}
