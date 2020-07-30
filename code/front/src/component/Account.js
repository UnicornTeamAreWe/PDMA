import React from "react";
import {Col, Input, Menu, Row,Button} from "antd";
import {AlipayCircleOutlined, WeiboCircleOutlined, CodeSandboxOutlined, AntCloudOutlined} from '@ant-design/icons';

export class Account extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            data: [],
            select: '1'
        }
    }

    navTransfer = (e) => {
        this.setState({
            select: e.key,
        })
    }

    Airpay = () => {
        return (<span>放二维码处</span>)
    }
    Weibo = () => {
        return (
            <div style={{margin:50}}>
                <span>放二维码处</span>
                <Input placeholder={'username'}/>
                <Input placeholder={'password'}/>
                <Button>提交</Button>
            </div>
        )
    }
    Meituan = () => {
        return (
            <div>
                <Input placeholder={'验证码'}/>
                <Button>提交</Button>
            </div>
        )
    }
    CloudMusic = () => {
        return (
            <div>
                <span>放二维码处</span>
                <Input placeholder={'username'}/>
                <Input placeholder={'password'}/>
                <Button>提交</Button>
            </div>
        )
    }
    Content = (key) => {
        switch (key) {
            case '1':
                return this.Airpay()
            case '2':
                return this.Weibo()
            case '3':
                return this.Meituan()
            case '4':
                return this.CloudMusic()
        }
    }


    render() {
        return (
            <Row>
                <Col span={4}>
                    <Menu mode="inline" selectedKeys={[this.state.select]} onClick={this.navTransfer}>
                        <Menu.Item key="1" icon={<AlipayCircleOutlined/>}>支付宝</Menu.Item>
                        <Menu.Item key="2" icon={<WeiboCircleOutlined/>}>微博</Menu.Item>
                        <Menu.Item key="3" icon={<CodeSandboxOutlined/>}>美团</Menu.Item>
                        <Menu.Item key="4" icon={<AntCloudOutlined/>}>网易云音乐</Menu.Item>
                    </Menu>
                </Col>
                <Col span={20}>{this.Content(this.state.select)}</Col>
            </Row>
        )
    }
}
