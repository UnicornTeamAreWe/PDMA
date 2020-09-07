import React from "react";
import {Layout, Menu, Breadcrumb} from 'antd';
import {
    PayCircleOutlined,
    CarOutlined,
    TeamOutlined,
    SmileOutlined,
    UserOutlined,
    KeyOutlined,
    EditOutlined,
    MoreOutlined
} from '@ant-design/icons';
import '../style.css'
import {Typography} from 'antd';
import {UserInfo} from "../component/UserInfo";
import {Account} from "../component/Account";
import {InfoEdit} from "../component/InfoEdit";
import {More} from "../component/More";
import {AmountByYear} from "../component/AmountByYear";
import {AmountByMonth} from "../component/AmountByMonth";
import {AmountByYearMonth} from "../component/AmountByYearMonth";
import {OrderNumberByMonth} from "../component/OrderNubmerByMonth";
import {OrderNumberByYearMonth} from "../component/OrderNumberByYearMonth";
import {OrderNumberByYear} from "../component/OrderNumberByYear";
import {Weibo_BasicInfo} from "../component/Weibo_BasicInfo";
import {Weibo_FollowInfo} from "../component/Weibo_FollowInfo";
import {Tongcheng} from "../component/Tongcheng";
import {Alipay_All} from "../component/Alipay_All";
import {Alipay_Det} from "../component/Alipay_Det";

const {Title} = Typography;
const {SubMenu} = Menu;
const {Header, Content, Footer, Sider} = Layout;


export class HomeScreen extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: [],
            nav: '1',
            home_nav: '1',
            user_nav: '个人信息',
            breadcrumb: '账单信息',
        }
    }

    homeLayout = () => {
        return (
            <Content style={{padding: '0 50px'}}>
                <Breadcrumb style={{margin: '16px 0'}}>
                    <Breadcrumb.Item>主页</Breadcrumb.Item>
                    <Breadcrumb.Item>{this.state.breadcrumb}</Breadcrumb.Item>
                    <Breadcrumb.Item>{this.state.home_nav}</Breadcrumb.Item>
                </Breadcrumb>
                <Layout className="site-layout-background" style={{padding: '24px 0'}}>
                    <Sider className="site-layout-background" width={200}>
                        <Menu
                            mode="inline"
                            selectedKeys={[this.state.home_nav]}
                            defaultOpenKeys={['账单信息']}
                            style={{height: '100%'}}
                            onClick={this.navTransfer1}
                        >
                            <SubMenu key="账单信息" icon={<PayCircleOutlined/>} title="账单信息">
                                <Menu.Item key="1">option1</Menu.Item>
                                <Menu.Item key="2">option2</Menu.Item>
                                <Menu.Item key="3">option3</Menu.Item>
                                <Menu.Item key="4">option4</Menu.Item>
                            </SubMenu>
                            <SubMenu key="出行信息" icon={<CarOutlined/>} title="出行信息">
                                <Menu.Item key="5">option5</Menu.Item>
                                <Menu.Item key="6">option6</Menu.Item>
                                <Menu.Item key="7">option7</Menu.Item>
                                <Menu.Item key="8">option8</Menu.Item>
                            </SubMenu>
                            <SubMenu key="社交信息" icon={<TeamOutlined/>} title="社交信息">
                                <Menu.Item key="9">option9</Menu.Item>
                                <Menu.Item key="10">option10</Menu.Item>
                                <Menu.Item key="11">option11</Menu.Item>
                                <Menu.Item key="12">option12</Menu.Item>
                            </SubMenu>
                        </Menu>
                    </Sider>
                    <Content style={{padding: '0 24px', minHeight: 280}}>
                        <AmountByYear/>
                        {/*<AmountByMonth/>*/}
                        {/*<AmountByYearMonth/>*/}
                        {/*<OrderNumberByYear/>*/}
                        {/*<OrderNumberByMonth/>*/}
                        {/*<OrderNumberByYearMonth/>*/}
                        {/*<Weibo_BasicInfo/>*/}
                        {/*<Weibo_FollowInfo/>*/}
                        {/*<Alipay_All/>*/}
                        {/*<Alipay_Det/>*/}
                        {/*<Tongcheng/>*/}
                    </Content>
                </Layout>
            </Content>
        )
    }
    userLayout = () => {
        return (
            <Content style={{padding: '0 50px'}}>
                <Breadcrumb style={{margin: '16px 0'}}>
                    <Breadcrumb.Item>我的</Breadcrumb.Item>
                    <Breadcrumb.Item>{this.state.user_nav}</Breadcrumb.Item>
                </Breadcrumb>
                <Layout className="site-layout-background" style={{padding: '24px 0'}}>
                    <Sider className="site-layout-background" width={200}>
                        <Menu
                            mode="inline"
                            selectedKeys={[this.state.user_nav]}
                            style={{height: '100%'}}
                            onClick={this.navTransfer2}
                        >
                            <Menu.Item key="个人信息" icon={<UserOutlined/>}>个人信息</Menu.Item>
                            <Menu.Item key="账户授权" icon={<KeyOutlined/>}>账户授权</Menu.Item>
                            <Menu.Item key="资料编辑" icon={<EditOutlined/>}>资料编辑</Menu.Item>
                            <Menu.Item key="更多" icon={<MoreOutlined/>}>更多</Menu.Item>
                        </Menu>
                    </Sider>
                    <Content
                        style={{padding: '0 24px', minHeight: 280}}>{this.contentSelect(this.state.user_nav)}</Content>
                </Layout>
            </Content>
        );
    }

    navTransfer = (e) => {
        this.setState({
            nav: e.key,
        })
    }
    navTransfer1 = (e) => {
        console.log(e)
        this.setState({
            home_nav: e.key,
            breadcrumb: e.keyPath[1]
        })
    }
    navTransfer2 = (e) => {
        this.setState({
            user_nav: e.key
        })
    }
    contentSelect = (key) => {
        switch (key) {
            case '个人信息':
                return (<UserInfo user={this.state.data}/>)
            case '账户授权':
                return (<Account/>)
            case '资料编辑':
                return (<InfoEdit/>)
            default:
                return (<More/>)
        }
    }

    componentDidMount() {
        if (!this.props.location.state) this.props.history.push('/login')
        console.log(this.props.location.state)
        this.setState({
            data:this.props.location.state
        })
    }

    render() {
        return (
            <Layout>
                <Header className="header">
                    <div className="logo" style={{float: 'left'}}>
                        <Title level={2} style={{marginTop: 9, marginRight: 20, color: '#fff'}}>PDMA</Title>
                    </div>
                    <Menu theme="dark" mode="horizontal" defaultSelectedKeys={[this.state.home_nav]}
                          onClick={this.navTransfer}>
                        <Menu.Item key="1">主页</Menu.Item>
                        <Menu.Item key="2">我的</Menu.Item>
                    </Menu>
                </Header>
                {this.state.nav === '1' ? this.homeLayout() : this.userLayout()}
                <Footer style={{textAlign: 'center'}}>Designed by {<SmileOutlined/>}UnicornTeamAreWe</Footer>
            </Layout>
        );
    }
}
