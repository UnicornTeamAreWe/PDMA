import React from 'react';
import Plot from 'react-plotly.js';
import axios from "axios";
import qs from "qs";
import { Typography, Divider } from 'antd';

const { Title, Paragraph, Text } = Typography;

const getTongcheng = async (id,setData)=>{
    axios.post("http://localhost:8088/getTongcheng", qs.stringify({ id: id }))
        .then(response =>{
            setData(response.data)
        })
        .catch(error=>console.log(error));
};


export function Tongcheng() {
    const [Tongcheng, setTongcheng] = React.useState([]);

    React.useEffect(() => {
        getTongcheng(1,(data)=>setTongcheng(data)).catch()
    },[]);

    console.log(Tongcheng);

    let Price = 0;
    let Price_sum = () =>{
        Price = 0;
        Tongcheng.forEach(item =>{
            if (item.state === '出票成功'){
                Price += item.price;
            }
        })
    }

    let title_info = [];
    let title_sum = [];
    let Title_Sum = () =>{
        Tongcheng.forEach(item =>{
            if (item.state === '出票成功'){
                let position;
                if (title_info.length === 0){
                    title_info.push(item.title);
                    title_sum.push(1);
                }
                else{
                    for (position = 0; position < title_info.length; ++position){
                        if (title_info[position] === item.title){
                            title_sum[position]++;
                            break;
                        }
                        else if (position === title_info.length-1){
                            title_info.push(item.title);
                            title_sum.push(1);
                            break;
                        }
                    }
                }
            }
        });
    }

    Title_Sum();
    Price_sum();

    let str = "";
    let i = 0;
    let Str = () => {
        i = 0;
        title_info.forEach(item => {
            str += item + "的票" + title_sum[i] + "张，";
        })
    }
    Str();


    let data1 = [
        {
            x: title_info,
            y: title_sum,
            type: 'bar'
        }
    ];

    let data2 = [
        {
            labels: title_info,
            values: title_sum,
            type: 'pie'
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 600, height: 400, title: 'Tongcheng Title Info'} }
            />
            <Plot
                data={data2}
                layout={ {width: 600, height: 400, title: 'Tongcheng Title Info'} }
            />
            <Typography>
                <Title>分析报告</Title>
                <Paragraph>
                    由图中内容可知，您曾在同城艺龙上购买过{str} 共消费{Price}元。
                </Paragraph>
            </Typography>
        </div>);
}
