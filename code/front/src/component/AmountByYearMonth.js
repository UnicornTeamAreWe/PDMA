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

export function AmountByYearMonth() {
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
    let AmountByYearMonth = [];

    let init = () =>{
        for (let i = 0; i <= Gap; ++i){
            AmountByYearMonth[i] = [];
            for(let j = 0; j <= 12; ++j){
                AmountByYearMonth[i][j] = 0;
            }
        }
    }
    init();

    let Amount = () =>{
        Taobao.forEach(item =>{
            AmountByYearMonth[2020-item.year][item.month-1] += item.amount;
        });
    }
    Amount();

    for (let i = 0; i <= Gap; ++i){
        let y = Year - i;
        let trace = {
                x: Month_arr,
                y: AmountByYearMonth[i],
                name: y,
                type: 'bar'
            };
        data1.push(trace);
    }

    for (let i = 0; i <= Gap; ++i){
        let y = Year - i;
        let trace = {
            x: Month_arr,
            y: AmountByYearMonth[i],
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
                width: 800,
                height: 600,
                title: 'Amount By Year Month',
                barmode: 'group'
            }}/>

            <Plot
                data={data2}
                layout={{
                    width: 800,
                    height: 600,
                    title: 'Amount By Year Month',
                    barmode: 'group'
                }}/>
        </div>
            );
}
