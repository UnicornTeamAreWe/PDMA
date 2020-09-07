import React from 'react';
import Plot from 'react-plotly.js';
import axios from "axios";
import qs from "qs";
import { Typography, Divider } from 'antd';

const { Title, Paragraph, Text } = Typography;

const getAlipay = async (id,setData)=>{
    axios.post("http://localhost:8088/getAlipay", qs.stringify({ id: id }))
        .then(response =>{
            setData(response.data)
        })
        .catch(error=>console.log(error));
};

export function Alipay_Det() {
    const [Alipay, setAlipay] = React.useState([]);

    React.useEffect(() => {
        getAlipay(1,(data)=>setAlipay(data)).catch()
    },[]);

    console.log(Alipay);
    let Income_name = [];
    let Income_amount = [];

    let Spend_name = [];
    let Spend_amount = [];

    let Calculate_Income = () =>{
        let Yu = -1;
        Alipay.forEach(item =>{
            if (item.funding_state != null && item.funding_state.indexOf('交易成功') >= 0){
                if (item.income_spending != null && item.income_spending.indexOf('收入') >= 0){
                    let position;
                    if (Income_name.length === 0){
                        if (item.name != null && item.name.indexOf('余额宝') >= 0){
                            Income_name.push('余额宝收益发放');
                            Income_amount.push(item.amount);
                            Yu = Income_name.indexOf('余额宝收益发放');

                        }
                        else{
                            Income_name.push(item.name);
                            Income_amount.push(item.amount);
                        }
                    }
                    else{
                        for (position = 0; position < Income_name.length; ++position){
                            if (item.name != null && item.name.indexOf('余额宝') >= 0){
                                if (Yu >= 0){
                                    Income_amount[Yu]+=item.amount;
                                    break;
                                }
                                else{
                                    Income_name.push('余额宝收益发放');
                                    Income_amount.push(item.amount);
                                    Yu = Income_name.indexOf('余额宝收益发放');
                                    break;
                                }
                            }
                            else if (Income_name[position] === item.name){
                                Income_amount[position]+=item.amount;
                                break;
                            }
                            else if (position === Income_name.length-1){
                                if (item.name != null && item.name.indexOf('余额宝') >= 0){
                                    Income_name.push('余额宝收益发放');
                                    Income_amount.push(item.amount);
                                    Yu = Income_name.indexOf('余额宝收益发放');
                                    break;
                                }
                                else{
                                    Income_name.push(item.name);
                                    Income_amount.push(item.amount);
                                    break;
                                }
                            }
                        }
                    }
                }

            }
        });
    }

    let Calculate_Spend = () =>{
        Alipay.forEach(item =>{
            if (item.funding_state != null && item.funding_state.indexOf('交易成功') >= 0){
                if (item.income_spending != null && item.income_spending.indexOf('支出') >= 0){
                    let position;
                    if (Spend_name.length === 0){
                        Spend_name.push(item.name);
                        Spend_amount.push(item.amount);
                    }
                    else{
                        for (position = 0; position < Spend_name.length; ++position){
                           if (Spend_name[position] === item.name){
                               Spend_amount[position]+=item.amount;
                               break;
                           }
                            else if (position === Spend_name.length-1){
                                Spend_name.push(item.name);
                                Spend_amount.push(item.amount);
                                break;
                            }
                        }
                    }
                }
            }
        });
    }


    Calculate_Income();
    Calculate_Spend();

    let length1 = Income_name.length;
    let length2 = Spend_name.length;

    let Str1 = "";
    let Income = ()=>{
        let i = 0;
        Income_name.forEach(item=>{
            Str1 += Income_name[i]+'部分收入'+Income_amount[i]+'元,';
            i++;
        })
    }
    Income();

    let Str2 = "";
    let Spend = ()=>{
        let i = 0;
        Spend_name.forEach(item=>{
            Str2 += Spend_name[i]+'部分支出'+Spend_amount[i]+'元,';
            i++;
        })
    }
    Spend();

    let Sum1 = 0;
    let Sum_Income = () =>{
        Sum1 = 0;
        Income_amount.forEach(item=>{
            Sum1 += item;
        })
    }
    Sum_Income();

    let Sum2 = 0;
    let Sum_Spend = () =>{
        Sum2 = 0;
        Spend_amount.forEach(item=>{
            Sum2 += item;
        })
    }
    Sum_Spend();

    let data1 = [
        {
            labels: Income_name,
            values: Income_amount,
            type: 'pie',
        }
    ];

    let data2 = [
        {
            labels: Spend_name,
            values: Spend_amount,
            type: 'pie',
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 600, height: 400, title: 'Alipay Income Detailed Info'} }
            />
            <Plot
                data={data2}
                layout={ {width: 600, height: 400, title: 'Alipay Spend Detailed Info'} }
            />
            <Typography>
                <Title>分析报告</Title>
                <Paragraph>
                    由图中内容可知，支付宝的收入主要由{length1}部分构成, 其中{Str1} 共收入{Sum1}元。
                </Paragraph>

                <Paragraph>
                    由图中内容可知，支付宝的支出主要由{length2}部分构成, 其中{Str2} 共支出{Sum2}元。
                </Paragraph>
            </Typography>
        </div>

    );
}
