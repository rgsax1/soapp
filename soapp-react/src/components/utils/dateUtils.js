import { parse, format } from 'date-fns';

const convertToISO8601 = (event) => {
  try {
    const formattedDate = event.target.value;
    const parsedDate = new Date(formattedDate);
    if (isNaN(parsedDate)) {
      // Trate datas inválidas aqui, por exemplo, retorne um valor padrão ou uma mensagem de erro.
    }
    const iso8601Date = parsedDate.toISOString();
    return iso8601Date;
  } catch (error) {
    console.error('Erro ao converter a data: ', error);
    return null;
  }
};



export { convertToISO8601 };
