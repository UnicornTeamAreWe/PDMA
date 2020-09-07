import React from 'react';
import Plot from 'react-plotly.js';
import axios from "axios";
import qs from "qs";
import {Typography} from "antd";

const { Title, Paragraph, Text } = Typography;

const getTaobaoAnalysis = async (id,setData)=>{
    axios.post("http://localhost:8088/getTaobaoAnalysis", qs.stringify({ id: id }))
        .then(response =>{
            setData(response.data)
        })
        .catch(error=>console.log(error));
};

export function OrderNumberByYearMonth() {
    const [Taobao, setTaobao] = React.useState([]);

    React.useEffect(() => {
        getTaobaoAnalysis(1,(data)=>setTaobao(data)).catch()
    },[]);

    let Month_arr = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    let min = Math.min.apply(Math, Taobao.map(item=> {return item.year}));
    let data1 = [];
    let data2 = [];
    let Year = new Date().getFullYear();
    let Gap = Year - min;
    let OrderNumberByYearMonth = [];

    let init = () =>{
        for (let i = 0; i <= Gap; ++i){
            OrderNumberByYearMonth[i] = [];
            for(let j = 0; j <= 12; ++j){
                OrderNumberByYearMonth[i][j] = 0;
            }
        }
    }
    init();

    let OrderNumber = () =>{
        Taobao.forEach(item =>{
            OrderNumberByYearMonth[2020-item.year][item.month-1] += item.order_number;
        });
    }
    OrderNumber();

    for (let i = 0; i <= Gap; ++i){
        let y = Year - i;
        let trace = {
                x: Month_arr,
                y: OrderNumberByYearMonth[i],
                name: y,
                type: 'bar'
            };
        data1.push(trace);
    }

    for (let i = 0; i <= Gap; ++i){
        let y = Year - i;
        let trace = {
            x: Month_arr,
            y: OrderNumberByYearMonth[i],
            name: y,
            type: 'scatter'
        };
        data2.push(trace);
    }

    return (
        <div>
            <Plot
            data={data1}
            layout={{
                width: 600,
                height: 400,
                title: 'Order Number By Year Month',
                barmode: 'group'
            }}/>

            <Plot
                data={data2}
                layout={{
                    width: 600,
                    height: 400,
                    title: 'Order Number By Year Month',
                    barmode: 'group'
                }}/>
            <Typography>
                <Title>分析报告</Title>
                <Paragraph>
                    图中展示了每年您在淘宝上每个月订单的数量，您可以从中获知每个月消费数量的走势。
                </Paragraph>
            </Typography>
        </div>

            );
}
