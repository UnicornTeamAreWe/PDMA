import React from 'react';
import Plot from 'react-plotly.js';
import axios from "axios";
import qs from "qs";

const getTaobaoAnalysis = async (id,setData)=>{
    axios.post("http://localhost:8088/getTaobaoAnalysis", qs.stringify({ id: id }))
        .then(response =>{
            setData(response.data)
        })
        .catch(error=>console.log(error));
};

export function OrderNumberByYear() {
    const [Taobao, setTaobao] = React.useState([]);

    React.useEffect(() => {
        getTaobaoAnalysis(1,(data)=>setTaobao(data)).catch()
    },[]);

    let min = Math.min.apply(Math, Taobao.map(item=> {return item.year}));
    let Year = new Date().getFullYear();
    let Gap = Year - min;
    let OrderNumberByYear = Array.from({length:Gap+1}).fill(0)
    let year_arr = [];
    let Number = () =>{
        Taobao.forEach(item =>{
            OrderNumberByYear[2020-item.year] += item.order_number;
        });
        for (let i = 0; i <= Gap; ++i){
            let y = Year-i;
            year_arr.push(y.toString());
        }
    }
    Number();

    let data1 = [
        {
            x: year_arr,
            y: OrderNumberByYear,
            type: 'bar'
        }
    ];

    let data2 = [
        {
            x: year_arr,
            y: OrderNumberByYear,
            type: 'scatter'
        }
    ];

    let data3 = [
        {
            labels:  year_arr,
            values: OrderNumberByYear,
            type: 'pie'
        }
    ];

    return (
        <div>
            <Plot
                data={data1}
                layout={ {width: 800, height: 600, title: 'Order Number By Month'} }
            />
            <Plot
                data={data2}
                layout={ {width: 800, height: 600, title: 'Order Number By Month'} }
            />
            <Plot
                data={data3}
                layout={ {width: 800, height: 600, title: 'Order Number By Month'} }
            />
        </div>);
}
