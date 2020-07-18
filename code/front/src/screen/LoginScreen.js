import React from "react";
import {Form, Input, Button, Checkbox, Col, Row, message, Modal} from "antd";

const layout = {
    labelCol: {span: 8},
    wrapperCol: {span: 16},
};
const tailLayout = {
    wrapperCol: {offset: 8, span: 16},
};
const validateMessages = {
    required: '${label} is required!',
    types: {
        email: '${label} is not validate email!',
        number: '${label} is not a validate number!',
    },
    number: {
        range: '${label} must be between ${min} and ${max}',
    },
};

export class LoginScreen extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            visible: false
        }
    }

    onFinish = values => {
        console.log('Success:', values);
        this.checkUser(values.username, values.password)
    };

    onFinishFailed = errorInfo => {
        console.log('Failed:', errorInfo);
    };
    registerFinish = values => {
        console.log(values)
        this.register(values.user)
    }
    register = (user) => {
        let userStr = JSON.stringify(user)
        let opts = {
            method: 'POST',
            body: userStr,
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
        }

        fetch('http://localhost:8088/register', opts)
            .then(response => response.json())
            .then(res => {
                console.log(res)
                switch (res.status) {
                    case 0:
                        message.error(res.message);
                        break;
                    case 1:
                        message.info(res.message);
                        this.setState({visible: false})
                }
            })
    }
    alert = res => {
        switch (res.status) {
            case 0:
                return message.error(res.message)
            case -1:
                return message.error(res.message)
            case 1:case 100:
                return this.props.history.push({pathname:'/',state:res.user})
        }
    };
    checkUser = (username, pwd) => {
        let data = {
            username: username,
            password: pwd
        }
        let datastr = JSON.stringify(data)

        let opts = {
            method: 'POST',
            body: datastr,
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
        }
        fetch('http://localhost:8088/login', opts)
            .then(response => response.json())
            .then(res => {
                console.log(res)
                this.alert(res)
            }).catch(function (ex) {
            console.log(ex)
        })
    };
    showModal = () => {
        this.setState({
            visible: true,
        });
    };
    handleCancel = e => {
        console.log(e);
        this.setState({
            visible: false,
        });
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
                                marginTop: 200,
                                borderRadius: 25,
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
                                <Button type="primary" htmlType="submit" style={{width: '50%'}}>
                                    登陆
                                </Button>
                                <br/>
                                Or
                                <Button type={"link"} onClick={this.showModal}>Register Now</Button>
                                <Modal
                                    title="Basic Modal"
                                    visible={this.state.visible}
                                    footer={null}
                                    onCancel={this.handleCancel}
                                >
                                    <Form {...layout} name="nest-messages" onFinish={this.registerFinish}
                                          validateMessages={validateMessages}>
                                        <Form.Item name={['user', 'username']} label="Username"
                                                   rules={[{required: true}]}>
                                            <Input/>
                                        </Form.Item>
                                        <Form.Item name={['user', 'email']} label="Email"
                                                   rules={[{type: 'email', required: true}]}>
                                            <Input/>
                                        </Form.Item>
                                        <Form.Item name={['user', 'password']} label="Password"
                                                   rules={[{required: true}]}>
                                            <Input/>
                                        </Form.Item>
                                        <Form.Item name={'repeat'} label="Repeat Password"
                                                   rules={[
                                                       {
                                                           required: true,
                                                           message: 'Please confirm your password!',
                                                       },
                                                       ({getFieldValue}) => ({
                                                           validator(rule, value) {
                                                               if (!value || getFieldValue(['user', 'password']) === value) {
                                                                   return Promise.resolve();
                                                               }
                                                               return Promise.reject('The two passwords that you entered do not match!');
                                                           },
                                                       }),
                                                   ]}>
                                            <Input/>
                                        </Form.Item>
                                        <Form.Item wrapperCol={{...layout.wrapperCol, offset: 8}}>
                                            <Button type="primary" htmlType="submit">
                                                Submit
                                            </Button>
                                        </Form.Item>
                                    </Form>
                                </Modal>
                            </Form.Item>
                        </Form>
                    </Col>
                    <Col span={8}/>
                </Row>
            </div>
        )
    }
}
